package com.testinium.testiniumAssesment.controller;

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


}
