package com.sugardread.leetcodeapplication.service;

import com.sugardread.leetcodeapplication.domain.dto.CategoryDto;

import java.util.List;

public interface CategoryService {
    List<CategoryDto> getAllCategories();
    CategoryDto createCategory(CategoryDto categoryDto);
}
