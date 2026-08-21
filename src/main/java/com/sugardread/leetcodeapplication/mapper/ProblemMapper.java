package com.sugardread.leetcodeapplication.mapper;

import com.sugardread.leetcodeapplication.domain.dto.ProblemDto;
import com.sugardread.leetcodeapplication.domain.entity.Category;
import com.sugardread.leetcodeapplication.domain.entity.Problem;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.Set;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public final class ProblemMapper {

    public static ProblemDto toDto(Problem problem) {
        return ProblemDto.builder()
                .title(problem.getTitle())
                .slug(problem.getSlug())
                .difficulty(problem.getDifficulty())
                .description(problem.getDescription())
                .categorySlugs(
                        problem.getCategories().stream()
                                .map(Category::getSlug)
                                .collect(Collectors.toSet())
                )
                .build();
    }

    public static Problem toEntity(ProblemDto problemDto, Set<Category> categorySet) {
        return Problem.builder()
                .title(problemDto.getTitle())
                .slug(problemDto.getSlug())
                .difficulty(problemDto.getDifficulty())
                .description(problemDto.getDescription())
                .categories(categorySet)
                .createdAt(Instant.now())
                .updatedAt(Instant.now())
                .build();
    }
}
