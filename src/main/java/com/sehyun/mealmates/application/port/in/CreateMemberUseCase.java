package com.sehyun.mealmates.application.port.in;

public interface CreateMemberUseCase {
    Long createMember(String name, String phoneNumber);
}
