package com.enzubis.bookshelf_spring.book;

import com.enzubis.bookshelf_spring.author.Author;
import com.enzubis.bookshelf_spring.bookshelf.Bookshelf;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "book_authors",
            joinColumns = @JoinColumn(name = "book_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "author_id", referencedColumnName = "id")
    )
    private Set<Author> authors = new HashSet<>();

    private String genre;

    @Column(unique = true)
    private int isbn;

    @ManyToMany(mappedBy = "books")
    private Set<Bookshelf> bookshelves = new HashSet<>();

    public Book() {
    }

    public Book(String title, Set<Author> authors, String genre, int isbn) {
        this.title = title;
        this.authors = authors;
        this.genre = genre;
        this.isbn = isbn;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Set<Author> getAuthor() {
        return authors;
    }


    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author=" + authors +
                ", genre='" + genre + '\'' +
                ", isbn=" + isbn +
                '}';
    }
}
