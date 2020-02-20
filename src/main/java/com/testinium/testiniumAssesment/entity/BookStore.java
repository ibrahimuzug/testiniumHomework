package com.testinium.testiniumAssesment.entity;


import javax.persistence.*;
import java.util.Set;

@Entity
public class BookStore {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column
    private String name;

    @Column
    private String city;

    @OneToMany(mappedBy = "bookStore", cascade = CascadeType.ALL)
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
