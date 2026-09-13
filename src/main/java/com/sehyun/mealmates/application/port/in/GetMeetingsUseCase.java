package com.sehyun.mealmates.application.port.in;

import com.sehyun.mealmates.domain.meeting.Meeting;

import java.util.List;

public interface GetMeetingsUseCase {
    List<Meeting> getMeetings();
}
