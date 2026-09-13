package com.sehyun.mealmates.domain.payment;

import com.sehyun.mealmates.domain.dues.Dues;
import com.sehyun.mealmates.domain.meetingmember.MeetingMember;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "payment",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "uk_payment_dues_meeting_member",
                        columnNames = {"meeting_member_id", "dues_id"}
                )
        }
)
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dues_id", nullable = false)
    private Dues dues;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "meeting_member_id", nullable = false)
    private MeetingMember meetingMember;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private PaymentStatus status;

    @Column(name = "paid_at")
    private LocalDateTime paidAt;

    private Payment(Dues dues, MeetingMember meetingMember) {
        this.dues = dues;
        this.meetingMember = meetingMember;
        this.paidAt = null;
    }

    public static Payment create(Dues dues, MeetingMember meetingMember) {
        return new Payment(dues, meetingMember);
    }

    public void pay() {
        this.status = PaymentStatus.PAID;
        this.paidAt = LocalDateTime.now();
    }
}