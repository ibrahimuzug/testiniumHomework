package com.testinium.testiniumAssesment.dto;

import com.testinium.testiniumAssesment.entity.Book;

import java.util.Set;

public class BookStoreDto {

    private Integer id;
    private String name;
    private String city;
    private Set<Book> book;


    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Set<Book> getBook() {
        return book;
    }

    public void setBook(Set<Book> book) {
        this.book = book;
    }
}
