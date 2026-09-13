package com.sehyun.mealmates.adapter.in.web;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CreateMeetingRequest(
        @NotBlank
        @Size(max = 100)
        String name,

        @Size(max = 200)
        String description
) {
}