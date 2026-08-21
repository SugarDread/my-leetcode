package com.sugardread.leetcodeapplication.service.impl;

import com.sugardread.leetcodeapplication.domain.dto.ProblemDto;
import com.sugardread.leetcodeapplication.domain.entity.Category;
import com.sugardread.leetcodeapplication.domain.entity.Problem;
import com.sugardread.leetcodeapplication.mapper.ProblemMapper;
import com.sugardread.leetcodeapplication.repository.CategoryRepository;
import com.sugardread.leetcodeapplication.repository.ProblemRepository;
import com.sugardread.leetcodeapplication.service.ProblemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProblemServiceImpl implements ProblemService {

    private final ProblemRepository problemRepository;
    private final CategoryRepository categoryRepository;

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
    public ProblemDto createProblem(ProblemDto problemToCreate) {
        // TODO: проверить на существование проблемы
        Set<Category> categorySet = problemToCreate.getCategorySlugs()
                .stream()
                .map(slug -> categoryRepository.findBySlug(slug).orElseThrow(
                        () -> new NoSuchElementException("Category not found: " + slug)
                ))
                .collect(Collectors.toSet());
        Problem problem = ProblemMapper.toEntity(problemToCreate, categorySet);
        return ProblemMapper.toDto(problemRepository.save(problem));
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
