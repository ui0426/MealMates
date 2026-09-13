package com.sehyun.mealmates.adapter.in.web;

import com.sehyun.mealmates.application.port.in.CreateMeetingUseCase;
import com.sehyun.mealmates.application.port.in.GetMeetingsUseCase;
import com.sehyun.mealmates.domain.meeting.Meeting;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MeetingController {

    private final CreateMeetingUseCase createMeetingUseCase;
    private final GetMeetingsUseCase getMeetingsUseCase;

    @PostMapping("/meetings")
    public ResponseEntity<Long> createMeeting(@Valid @RequestBody CreateMeetingRequest request) {
        Long meetingId = createMeetingUseCase.createMeeting(request.name(), request.description());
        return ResponseEntity.status(HttpStatus.CREATED).body(meetingId);
    }

    @GetMapping("/meetings")
    public ResponseEntity<List<MeetingResponse>> getMeetings() {
        List<Meeting> meetings = getMeetingsUseCase.getMeetings();
        return ResponseEntity.ok(
                meetings.stream()
                        .map((meeting) -> new MeetingResponse(
                                meeting.getId(),
                                meeting.getName(),
                                meeting.getDescription()
                        ))
                        .toList()
        );
    }

}
