package com.sugardread.leetcodeapplication.repository;

import com.sugardread.leetcodeapplication.domain.entity.TestCase;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestCaseRepository extends JpaRepository<TestCase, Long> {
}
