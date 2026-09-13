package com.sehyun.mealmates.application.port.in;

public interface CreateMeetingUseCase {
    Long createMeeting(String name, String description);
}
