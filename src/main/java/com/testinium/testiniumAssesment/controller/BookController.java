package com.testinium.testiniumAssesment.controller;


import com.testinium.testiniumAssesment.dto.BookDto;
import com.testinium.testiniumAssesment.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/book")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/{id}")
    public @ResponseBody
    Optional<BookDto> getBookById(@PathVariable("id") Integer id) {
        return bookService.getBookById(id);
    }

    @PostMapping("/create")
    public void createBook(@RequestBody BookDto bookDto) {
        bookService.createBook(bookDto);
    }


}
