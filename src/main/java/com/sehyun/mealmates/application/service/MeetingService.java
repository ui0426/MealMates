package com.sehyun.mealmates.application.service;

import com.sehyun.mealmates.application.port.in.CreateMeetingUseCase;
import com.sehyun.mealmates.application.port.in.GetMeetingsUseCase;
import com.sehyun.mealmates.application.port.out.MeetingRepositoryPort;
import com.sehyun.mealmates.domain.meeting.Meeting;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class MeetingService implements CreateMeetingUseCase, GetMeetingsUseCase {

    private final MeetingRepositoryPort meetingRepositoryPort;

    @Override
    public Long createMeeting(String name, String description) {
        Meeting savedMeeting = meetingRepositoryPort.save(Meeting.create(name, description));
        return savedMeeting.getId();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Meeting> getMeetings() {
        return meetingRepositoryPort.findAll();
    }
}