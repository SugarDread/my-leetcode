package com.sugardread.leetcodeapplication.domain.entity;

import com.sugardread.leetcodeapplication.domain.enums.ProgrammingLanguage;
import com.sugardread.leetcodeapplication.domain.enums.SubmissionStatus;
import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;

@Entity
@Table(name = "submissions")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Submission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "problem_id", nullable = false)
    private Problem problem;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private ProgrammingLanguage language;

    @Column(nullable = false, name = "source_code", columnDefinition = "TEXT")
    private String sourceCode;

    @Column(nullable = false, name = "status")
    @Enumerated(EnumType.STRING)
    private SubmissionStatus submissionStatus;

    @Column(name = "runtime_ms")
    private Integer runtimeMs;

    @Column(name = "memory_kb")
    private Integer memoryKb;

    @Column(nullable = false, name = "created_at")
    private Instant createdAt;




}
