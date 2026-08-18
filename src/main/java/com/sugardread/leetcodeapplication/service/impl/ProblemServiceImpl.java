package com.sugardread.leetcodeapplication.service.impl;

import com.sugardread.leetcodeapplication.domain.dto.ProblemDto;
import com.sugardread.leetcodeapplication.mapper.ProblemMapper;
import com.sugardread.leetcodeapplication.repository.ProblemRepository;
import com.sugardread.leetcodeapplication.service.ProblemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProblemServiceImpl implements ProblemService {

    private final ProblemRepository problemRepository;

    @Override
    public List<ProblemDto> getAllProblems() {
        return problemRepository.findAll().stream()
                .map(ProblemMapper::toDto)
                .toList();
    }

    @Override
    public List<ProblemDto> getAllProblemsWithCategories() {
        return problemRepository.findAllWithCategories().stream()
                .map(ProblemMapper::toDto)
                .toList();
    }

    @Override
    public List<ProblemDto> getAllProblemsByCategory(String category) {
        return problemRepository.findProblemsByCategory(category).stream()
                .map(ProblemMapper::toDto)
                .toList();
    }

    @Override
    public ProblemDto getProblemById(Long id) {
        return null;
    }
}
