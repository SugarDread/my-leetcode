package com.sugardread.leetcodeapplication.service;

import com.sugardread.leetcodeapplication.domain.dto.ProblemDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProblemService {
    List<ProblemDto> getAllProblems();
    List<ProblemDto> getAllProblemsByCategory(String category);
    ProblemDto getProblemById(Long id);
    List<ProblemDto> getAllProblemsWithCategories();

}
