package com.sehyun.mealmates.adapter.out.persistence;

import com.sehyun.mealmates.application.port.out.MemberRepositoryPort;
import com.sehyun.mealmates.domain.member.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class MemberPersistenceAdapter implements MemberRepositoryPort {

    private final MemberJpaRepository memberJpaRepository;

    @Override
    public Member save(Member member) {
        return memberJpaRepository.save(member);
    }

    @Override
    public List<Member> findAll() {
        return memberJpaRepository.findAll();
    }
}