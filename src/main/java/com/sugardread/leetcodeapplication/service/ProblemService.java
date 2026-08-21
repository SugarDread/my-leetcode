package com.sugardread.leetcodeapplication.service;

import com.sugardread.leetcodeapplication.domain.dto.ProblemDto;

import java.util.List;

public interface ProblemService {
    List<ProblemDto> getAllProblems();
    List<ProblemDto> getAllProblemsByCategory(String category);
    ProblemDto getProblemById(Long id);
    List<ProblemDto> getAllProblemsWithCategories();
    ProblemDto createProblem(ProblemDto problemToCreate);
}
