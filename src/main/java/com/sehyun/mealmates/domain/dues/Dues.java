package com.sehyun.mealmates.domain.dues;

import com.sehyun.mealmates.domain.meeting.Meeting;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "dues",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "uk_dues_meeting_month",
                        columnNames = {"meeting_id", "base_month"}
                )
        }
)
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Dues {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long amount;

    @Column(name = "base_month", nullable = false)
    private LocalDate baseMonth;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "meeting_id", nullable = false)
    private Meeting meeting;

    private Dues(Long amount, LocalDate baseMonth, Meeting meeting) {
        this.amount = amount;
        this.baseMonth = baseMonth.withDayOfMonth(1);
        this.meeting = meeting;
    }

    public static Dues create(Long amount, LocalDate baseMonth, Meeting meeting) {
        return new Dues(amount, baseMonth, meeting);
    }

}