package com.testinium.testiniumAssesment.service;

import com.testinium.testiniumAssesment.dto.BookDto;

import java.util.Optional;

public interface BookService {
    Optional<BookDto> getBookById(Integer id);

    void createBook(BookDto bookDto);
}
