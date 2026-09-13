package com.sehyun.mealmates.domain.meetingmember;

import com.sehyun.mealmates.domain.meeting.Meeting;
import com.sehyun.mealmates.domain.member.Member;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "meeting_member",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "uk_meeting_member",
                        columnNames = {"meeting_id", "member_id"}
                )
        }
)
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MeetingMember {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "meeting_id", nullable = false)
    private Meeting meeting;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id", nullable = false)
    private Member member;

    @Column(nullable = false)
    private LocalDateTime joinedAt;

    private MeetingMember(Meeting meeting, Member member) {
        this.meeting = meeting;
        this.member = member;
        this.joinedAt = LocalDateTime.now();
    }

    public static MeetingMember create(Meeting meeting, Member member) {
        return new MeetingMember(meeting, member);
    }
}