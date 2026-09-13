package com.sehyun.mealmates.application.port.in;

import com.sehyun.mealmates.domain.member.Member;

import java.util.List;

public interface GetMembersUseCase {
    List<Member> getMembers();
}
