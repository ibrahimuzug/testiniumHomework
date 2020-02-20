package com.testinium.testiniumAssesment.controller;

import com.testinium.testiniumAssesment.dto.BookDto;
import com.testinium.testiniumAssesment.service.BookService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Optional;

import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class BookControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private BookService bookService;

    @Test
    void getBookById() throws Exception {
        BookDto bookDto = new BookDto();
        bookDto.setName("Ölü Canlar");
        bookDto.setCategory("Klasik Roman");
        bookDto.setBookStore("Doğuş Yayınevi");
        bookDto.setPrice(12.5);
        when(bookService.getBookById(1)).thenReturn(Optional.of(bookDto));

        mockMvc.perform(MockMvcRequestBuilders
                .get("/book/{id}", 1)
                .accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(""));
    }

    @Test
    void createBook() {
    }
}