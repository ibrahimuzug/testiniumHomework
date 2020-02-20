package com.testinium.testiniumAssesment.service.impl;

import com.testinium.testiniumAssesment.dao.BookDao;
import com.testinium.testiniumAssesment.dao.BookStoreDao;
import com.testinium.testiniumAssesment.dto.BookDto;
import com.testinium.testiniumAssesment.dto.BookStoreDto;
import com.testinium.testiniumAssesment.entity.Book;
import com.testinium.testiniumAssesment.entity.BookStore;
import com.testinium.testiniumAssesment.service.BookStoreService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookStoreServiceImpl implements BookStoreService {

    private final BookStoreDao bookStoreDao;

    private final BookDao bookDao;

    public BookStoreServiceImpl(BookStoreDao bookStoreDao, BookDao bookDao) {
        this.bookStoreDao = bookStoreDao;
        this.bookDao = bookDao;
    }

    @Override
    public Optional<BookStoreDto> getBookStoreById(Integer id) {
        Optional<BookStore> bookStoreOptional = bookStoreDao.findById(id);
        if (bookStoreOptional.isPresent()) {
            BookStore bookStore = bookStoreOptional.get();
            BookStoreDto bookStoreDto = new BookStoreDto();
            bookStoreDto.setName(bookStore.getName());
            bookStoreDto.setCity(bookStore.getCity());
            return Optional.of(bookStoreDto);
        }
        return null;
    }

    @Override
    public void createBookStore(BookStoreDto bookStoreDto) {
        BookStore bookStore = new BookStore();
        bookStore.setName(bookStoreDto.getName());
        bookStore.setCity(bookStoreDto.getCity());
        bookStoreDao.save(bookStore);
    }

    public void createBookToStore(BookDto bookDto) {
        Book book = new Book();
        book.setName(bookDto.getName());
        book.setCategory(bookDto.getCategory());
        book.setBookStore(bookDto.getBookStore());
        book.setPrice(bookDto.getPrice());
        bookDao.save(book);
    }

    public void deleteBookFromStore(Integer id) {
        Optional<Book> bookOptional = bookDao.findById(id);
        deleteBookFromStore(id);
    }

}
