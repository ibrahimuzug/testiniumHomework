package com.testinium.testiniumAssesment.dao;

import com.testinium.testiniumAssesment.entity.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BookDao extends CrudRepository<Book, Long> {
    Optional<Book> findById(Integer id);

    void createBook(Book book);
}
