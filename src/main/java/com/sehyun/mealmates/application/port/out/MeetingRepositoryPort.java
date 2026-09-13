package com.sehyun.mealmates.application.port.out;

import com.sehyun.mealmates.domain.meeting.Meeting;

import java.util.List;

public interface MeetingRepositoryPort {
    Meeting save(Meeting meeting);

    List<Meeting> findAll();
}
