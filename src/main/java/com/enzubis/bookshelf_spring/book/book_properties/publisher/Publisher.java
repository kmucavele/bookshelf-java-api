package com.enzubis.bookshelf_spring.book.book_properties.publisher;

import com.enzubis.bookshelf_spring.book.Book;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "publisher")
public class Publisher {
    @Id
    @JsonIgnore
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "publisher")
    private String publisher;


    @JsonIgnore
    @OneToMany(mappedBy = "publisher")
    private List<Book> publishedBooks = new ArrayList<>();


    public Publisher() {
    }

    public Publisher(String publisher) {
        this.publisher = publisher;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public List<Book> getPublishedBooks() {
        return publishedBooks;
    }

    public void setPublishedBooks(List<Book> publishedBooks) {
        this.publishedBooks = publishedBooks;
    }

    @Override
    public String toString() {
        return "Publisher{" +
                "id=" + id +
                ", publisher='" + publisher + '\'' +
                ", publishedBooks=" + publishedBooks +
                '}';
    }
}
