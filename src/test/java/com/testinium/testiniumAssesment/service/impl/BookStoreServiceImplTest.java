package com.testinium.testiniumAssesment.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.testinium.testiniumAssesment.dto.BookStoreDto;
import com.testinium.testiniumAssesment.entity.BookStore;
import com.testinium.testiniumAssesment.service.BookStoreService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class BookStoreServiceImplTest {

    @Mock
    BookStoreService bookStoreServiceMock;
    @InjectMocks
    BookStoreServiceImpl bookStoreServiceImpl;
    @Autowired
    private MockMvc mockMvc;
    private BookStoreDto bookStoreDto;

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void getBookStoreById() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .get("/bookStore/{id}", 1)
                .accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(""));
    }

    @Test
    void createBookStore() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .post("/bookStore/create")
                .content(asJsonString(new BookStore()))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.content().string(""));
    }

    @Test
    void createBookToStore() {
    }

    @Test
    void deleteBookFromStore() {
    }
}