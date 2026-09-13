package com.sehyun.mealmates.application.service;

import com.sehyun.mealmates.application.port.in.CreateMemberUseCase;
import com.sehyun.mealmates.application.port.in.GetMembersUseCase;
import com.sehyun.mealmates.application.port.out.MemberRepositoryPort;
import com.sehyun.mealmates.domain.member.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class MemberService implements CreateMemberUseCase, GetMembersUseCase {

    private final MemberRepositoryPort memberRepositoryPort;

    @Override
    public Long createMember(String name, String phoneNumber) {
        Member savedMember = memberRepositoryPort.save(Member.create(name, phoneNumber));
        return savedMember.getId();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Member> getMembers() {
        return memberRepositoryPort.findAll();
    }
}