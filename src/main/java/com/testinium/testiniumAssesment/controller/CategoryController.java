package com.testinium.testiniumAssesment.controller;


import com.testinium.testiniumAssesment.dto.CategoryDto;
import com.testinium.testiniumAssesment.service.CategoryService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/category")
public class CategoryController {
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/{id}")
    public @ResponseBody
    Optional<CategoryDto> getCategoryById(@PathVariable("id") Integer id) {
        return categoryService.getCategoryById(id);
    }


    @PostMapping("/create")
    public void createCategory(@RequestBody CategoryDto categoryDto) {
        categoryService.createCategory(categoryDto);
    }
}
