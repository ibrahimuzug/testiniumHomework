package com.testinium.testiniumAssesment.controller;

import com.testinium.testiniumAssesment.dto.BookStoreDto;
import com.testinium.testiniumAssesment.service.BookService;
import com.testinium.testiniumAssesment.service.BookStoreService;
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
class BookStoreControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private BookStoreService bookStoreService;

    @Test
    void getBookStoreById() throws Exception {
        BookStoreDto bookStoreDto = new BookStoreDto();
        bookStoreDto.setName("Doğuş Yayınevi");
        bookStoreDto.setCity("İstanbul");
        when(bookStoreService.getBookStoreById(1)).thenReturn(Optional.of(bookStoreDto));

        mockMvc.perform(MockMvcRequestBuilders
                .get("/bookStore/{id}", 1)
                .accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(""));
    }

    @Test
    void createBookStore() {

    }

    @Test
    void createBookToStore() {
    }

    @Test
    void deleteBookFromStore() {
    }
}