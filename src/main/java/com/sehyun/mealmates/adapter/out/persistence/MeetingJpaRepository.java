package com.sehyun.mealmates.adapter.out.persistence;

import com.sehyun.mealmates.domain.meeting.Meeting;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MeetingJpaRepository extends JpaRepository<Meeting, Long> {
}