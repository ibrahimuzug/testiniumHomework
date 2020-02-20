package com.testinium.testiniumAssesment.service.impl;

import com.testinium.testiniumAssesment.dao.CategoryDao;
import com.testinium.testiniumAssesment.dto.CategoryDto;
import com.testinium.testiniumAssesment.entity.Category;
import com.testinium.testiniumAssesment.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryDao categoryDao;

    public CategoryServiceImpl(CategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }

    @Override
    public Optional<CategoryDto> getCategoryById(Integer id) {
        Optional<Category> categoryOptional = categoryDao.findById(id);
        if (categoryOptional.isPresent()) {
            Category category = categoryOptional.get();
            CategoryDto categoryDto = new CategoryDto();
            categoryDto.setName(category.getName());
            return Optional.of(categoryDto);
        }
        return null;
    }

    @Override
    public void createCategory(CategoryDto categoryDto) {
        Category category = new Category();
        category.setName(categoryDto.getName());
        categoryDao.save(category);
    }
}
