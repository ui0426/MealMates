package com.sehyun.mealmates.domain.meeting;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "meeting")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Meeting {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(length = 200)
    private String description;

    private Meeting(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public static Meeting create(String name, String description) {
        return new Meeting(name, description);
    }

}