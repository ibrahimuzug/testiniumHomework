package com.testinium.testiniumAssesment.service.impl;

import com.testinium.testiniumAssesment.dao.BookDao;
import com.testinium.testiniumAssesment.dto.BookDto;
import com.testinium.testiniumAssesment.entity.Book;
import com.testinium.testiniumAssesment.service.BookService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    private final BookDao bookDao;

    public BookServiceImpl(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    @Override
    public Optional<BookDto> getBookById(Integer id) {
        Optional<Book> bookOptional = bookDao.findById(id);
        if (bookOptional.isPresent()) {
            Book book = bookOptional.get();
            BookDto bookDto = new BookDto();
            bookDto.setName(book.getName());
            bookDto.setCategory(book.getCategory());
            bookDto.setPrice(book.getPrice());
            return Optional.of(bookDto);
        }
        return null;
    }


    @Override
    public void createBook(BookDto bookDto) {
        Book book = new Book();
        book.setName(bookDto.getName());
        book.setCategory(bookDto.getCategory());
        book.setPrice(bookDto.getPrice());
        bookDao.save(book);
    }

}
