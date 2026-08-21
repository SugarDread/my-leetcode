package com.sugardread.leetcodeapplication.service.impl;

import com.sugardread.leetcodeapplication.domain.dto.CategoryDto;
import com.sugardread.leetcodeapplication.domain.entity.Category;
import com.sugardread.leetcodeapplication.mapper.CategoryMapper;
import com.sugardread.leetcodeapplication.repository.CategoryRepository;
import com.sugardread.leetcodeapplication.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Override
    public List<CategoryDto> getAllCategories() {
        List<Category> categories = categoryRepository.findAll();
        return categories.stream()
                .map(CategoryMapper::toDto)
                .toList();
    }

    @Override
    public CategoryDto createCategory(CategoryDto categoryDto) {
        // TODO: проверить на существование категорию
        return CategoryMapper.toDto(
                categoryRepository.save(
                        CategoryMapper.toEntity(categoryDto)
                )
        );
    }
}
