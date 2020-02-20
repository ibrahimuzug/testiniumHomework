package com.testinium.testiniumAssesment.service;

import com.testinium.testiniumAssesment.dto.BookDto;
import com.testinium.testiniumAssesment.dto.BookStoreDto;

import java.util.Optional;

public interface BookStoreService {
    Optional<BookStoreDto> getBookStoreById(Integer id);

    void createBookStore(BookStoreDto bookStoreDto);

    void createBookToStore(BookDto bookDto);

    void deleteBookFromStore(Integer id);
}
