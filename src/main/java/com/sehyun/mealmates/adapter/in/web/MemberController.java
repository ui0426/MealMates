package com.sehyun.mealmates.adapter.in.web;

import com.sehyun.mealmates.application.port.in.CreateMemberUseCase;
import com.sehyun.mealmates.application.port.in.GetMembersUseCase;
import com.sehyun.mealmates.domain.member.Member;
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
public class MemberController {

    private final CreateMemberUseCase createMemberUseCase;
    private final GetMembersUseCase getMembersUseCase;

    @PostMapping("/members")
    public ResponseEntity<Long> createMember(@Valid @RequestBody CreateMemberRequest request) {
        Long memberId = createMemberUseCase.createMember(request.name(), request.phoneNumber());
        return ResponseEntity.status(HttpStatus.CREATED).body(memberId);
    }

    @GetMapping("/members")
    public ResponseEntity<List<MemberResponse>> getMembers() {
        List<Member> members = getMembersUseCase.getMembers();
        return ResponseEntity.ok(
                members.stream()
                        .map((member) -> new MemberResponse(
                                member.getId()
                                , member.getName()
                                , member.getPhoneNumber()
                        ))
                        .toList());
    }

}
