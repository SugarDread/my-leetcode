package com.sugardread.leetcodeapplication.repository;

import com.sugardread.leetcodeapplication.domain.entity.Submission;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SubmissionRepository extends JpaRepository<Submission, Long> {
    List<Submission> findAllByUser_Username(String username);
}
