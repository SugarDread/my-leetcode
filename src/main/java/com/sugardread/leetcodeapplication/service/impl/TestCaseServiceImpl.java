package com.sugardread.leetcodeapplication.service.impl;

import com.sugardread.leetcodeapplication.domain.dto.TestCaseDto;
import com.sugardread.leetcodeapplication.domain.entity.TestCase;
import com.sugardread.leetcodeapplication.mapper.TestCaseMapper;
import com.sugardread.leetcodeapplication.repository.ProblemRepository;
import com.sugardread.leetcodeapplication.repository.TestCaseRepository;
import com.sugardread.leetcodeapplication.service.TestCaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class TestCaseServiceImpl implements TestCaseService {
    private final ProblemRepository problemRepository;
    private final TestCaseRepository testCaseRepository;

    @Override
    public TestCaseDto createTestCase(TestCaseDto testCaseDto) {
        TestCase createdTestCase = TestCase.builder()
                .problem(problemRepository.findProblemBySlug(
                        testCaseDto.getProblemSlug()).orElseThrow(
                        () -> new NoSuchElementException("Problem not found: " + testCaseDto.getProblemSlug())
                        )
                )
                .input(testCaseDto.getInput())
                .expectedOutput(testCaseDto.getExpectedOutput())
                .isSample(testCaseDto.isSample())
                .createdAt(Instant.now())
                .build();
        testCaseRepository.save(createdTestCase);

        return TestCaseMapper.toDto(createdTestCase);
    }
}
