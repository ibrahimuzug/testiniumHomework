package com.testinium.testiniumAssesment.dto;

import com.testinium.testiniumAssesment.entity.BookStore;
import com.testinium.testiniumAssesment.entity.Category;

public class BookDto {

    private String name;

    private Category category;

    private BookStore bookStore;

    private Double price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public BookStore getBookStore() {
        return bookStore;
    }

    public void setBookStore(BookStore bookStore) {
        this.bookStore = bookStore;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

}
