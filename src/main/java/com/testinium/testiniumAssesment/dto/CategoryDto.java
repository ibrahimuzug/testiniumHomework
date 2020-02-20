package com.testinium.testiniumAssesment.dto;

import com.testinium.testiniumAssesment.entity.Book;

import java.util.Set;

public class CategoryDto {
    private Integer id;

    private String name;

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

    public Set<Book> getBook() {
        return book;
    }

    public void setBook(Set<Book> book) {
        this.book = book;
    }
}
