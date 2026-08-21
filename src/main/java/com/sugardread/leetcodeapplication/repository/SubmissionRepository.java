package com.sugardread.leetcodeapplication.repository;

import com.sugardread.leetcodeapplication.domain.entity.Submission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubmissionRepository extends JpaRepository<Submission, Long> {
}
