package com.sugardread.leetcodeapplication.domain.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;

@Entity
@Table(name = "test_cases")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class TestCase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "problem_id", nullable = false)
    private Problem problem;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String input;

    @Column(nullable = false, name = "expected_output", columnDefinition = "TEXT")
    private String expectedOutput;

    @Column(nullable = false, name = "is_sample")
    private boolean isSample;

    @Column(nullable = false, name = "created_at")
    private Instant createdAt;
}
