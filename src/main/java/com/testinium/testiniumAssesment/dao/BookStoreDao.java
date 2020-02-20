package com.testinium.testiniumAssesment.dao;

import com.testinium.testiniumAssesment.entity.BookStore;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BookStoreDao extends CrudRepository<BookStore, Long> {
    Optional<BookStore> findById(Integer id);

    void createBookStore(BookStore bookStore);
}
