package com.sugardread.leetcodeapplication.domain.entity;

import com.sugardread.leetcodeapplication.domain.enums.Difficulty;
import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;

@Entity
@Table(name = "problems")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Problem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String title;

    @Column(nullable = false, unique = true)
    private String slug;

    @Column(nullable = false)
    private Difficulty difficulty;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false, name = "created_at")
    private Instant createdAt;

    @Column(nullable = false, name = "updated_at")
    private Instant updatedAt;

}
