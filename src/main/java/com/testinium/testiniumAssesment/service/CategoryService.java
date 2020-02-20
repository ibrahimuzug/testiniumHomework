package com.testinium.testiniumAssesment.service;

import com.testinium.testiniumAssesment.dto.CategoryDto;

import java.util.Optional;

public interface CategoryService {
    Optional<CategoryDto> getCategoryById(Integer id);

    void createCategory(CategoryDto bookDto);

    Optional<CategoryDto> updateCategoryById(Integer id, String category);
}
