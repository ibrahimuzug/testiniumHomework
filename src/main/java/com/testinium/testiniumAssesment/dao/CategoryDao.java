package com.testinium.testiniumAssesment.dao;

import com.testinium.testiniumAssesment.entity.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryDao extends CrudRepository<Category, Long> {
    Optional<Category> findById(Integer id);

    void createCategory(Category category);
}
