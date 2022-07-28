package com.enzubis.bookshelf_spring.book.book_properties.publisher;

import com.enzubis.bookshelf_spring.book.Book;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "publisher")
public class Publisher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "publisher")
    private String name;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "book_publishers",
            joinColumns = @JoinColumn(name = "book_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "publisher_id", referencedColumnName = "id")
    )
    private List<Book> books;


    public Publisher() {
    }

    public Publisher(String name) {
        this.name = name;
    }

    public String getPublisher() {
        return name;
    }

    public void setPublisher(String publisher) {
        this.name = publisher;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return "Publisher{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", books=" + books +
                '}';
    }
}
