package com.sehyun.mealmates.adapter.out.persistence;

import com.sehyun.mealmates.application.port.out.MeetingRepositoryPort;
import com.sehyun.mealmates.domain.meeting.Meeting;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class MeetingPersistenceAdapter implements MeetingRepositoryPort {

    private final MeetingJpaRepository meetingJpaRepository;

    @Override
    public Meeting save(Meeting meeting) {
        return meetingJpaRepository.save(meeting);
    }

    @Override
    public List<Meeting> findAll() {
        return meetingJpaRepository.findAll();
    }
}