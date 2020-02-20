package com.testinium.testiniumAssesment.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.testinium.testiniumAssesment.dao.BookStoreDao;
import com.testinium.testiniumAssesment.entity.BookStore;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

class BookStoreServiceTest {

    @InjectMocks
    BookStore bookStore;

    @Mock
    BookStoreDao bookStoreDao;

    @Autowired
    private MockMvc mockMvc;

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
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
                .content(asJsonString(new BookStore()))//Test data
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