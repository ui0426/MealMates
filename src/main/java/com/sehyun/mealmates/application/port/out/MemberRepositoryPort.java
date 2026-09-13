package com.sehyun.mealmates.application.port.out;

import com.sehyun.mealmates.domain.member.Member;

import java.util.List;

public interface MemberRepositoryPort {
    Member save(Member member);

    List<Member> findAll();
}
