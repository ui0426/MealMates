package com.sehyun.mealmates.adapter.out.persistence;

import com.sehyun.mealmates.domain.member.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberJpaRepository extends JpaRepository<Member, Long> {
}