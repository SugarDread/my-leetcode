package com.sugardread.leetcodeapplication.mapper;

import com.sugardread.leetcodeapplication.domain.dto.TestCaseDto;
import com.sugardread.leetcodeapplication.domain.entity.TestCase;
import org.springframework.stereotype.Component;

@Component
public final class TestCaseMapper {

    static public TestCaseDto toDto(TestCase testCase) {
        return TestCaseDto.builder()
                .problemSlug(testCase.getProblem().getSlug())
                .input(testCase.getInput())
                .expectedOutput(testCase.getExpectedOutput())
                .isSample(testCase.isSample())
                .build();
    }
}
