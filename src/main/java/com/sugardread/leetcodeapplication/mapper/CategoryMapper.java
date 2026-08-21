package com.sugardread.leetcodeapplication.mapper;

import com.sugardread.leetcodeapplication.domain.dto.CategoryDto;
import com.sugardread.leetcodeapplication.domain.entity.Category;
import org.springframework.stereotype.Component;

@Component
public final class CategoryMapper {

    public static CategoryDto toDto(Category category) {
        return CategoryDto.builder()
                .name(category.getName())
                .slug(category.getSlug())
                .build();
    }

    public static Category toEntity(CategoryDto categoryDto) {
        return Category.builder()
                .name(categoryDto.getName())
                .slug(categoryDto.getSlug())

                .build();
    }

}
