package com.testinium.testiniumAssesment.controller;

import com.testinium.testiniumAssesment.dto.BookDto;
import com.testinium.testiniumAssesment.dto.BookStoreDto;
import com.testinium.testiniumAssesment.service.BookStoreService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/bookStore")
public class BookStoreController {

    private final BookStoreService bookStoreService;


    public BookStoreController(BookStoreService bookStoreService) {
        this.bookStoreService = bookStoreService;
    }

    @GetMapping("/{id}")
    public @ResponseBody
    Optional<BookStoreDto> getBookStoreById(@PathVariable("id") Integer id) {
        return bookStoreService.getBookStoreById(id);
    }


    @PostMapping("/create")
    public void createBookStore(@RequestBody BookStoreDto bookStoreDto) {
        bookStoreService.createBookStore(bookStoreDto);
    }

    @PostMapping("/createBookToStore")
    public void createBookToStore(@RequestBody BookDto bookDto) {
        bookStoreService.createBookToStore(bookDto);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteBookFromStore(@PathVariable("id") Integer id) {
        bookStoreService.deleteBookFromStore(id);
    }


}
