package com.sugardread.leetcodeapplication.mapper;

import com.sugardread.leetcodeapplication.domain.dto.ProblemDto;
import com.sugardread.leetcodeapplication.domain.entity.Problem;
import org.springframework.stereotype.Component;

@Component
public final class ProblemMapper {

    public static ProblemDto toDto(Problem problem) {
        return ProblemDto.builder()
                .title(problem.getTitle())
                .slug(problem.getSlug())
                .difficulty(problem.getDifficulty())
                .description(problem.getDescription())
                .build();
    }

    public static Problem toEntity(ProblemDto problemDto) {
        return Problem.builder()
                .title(problemDto.getTitle())
                .slug(problemDto.getSlug())
                .difficulty(problemDto.getDifficulty())
                .description(problemDto.getDescription())
                .build();
    }
}
