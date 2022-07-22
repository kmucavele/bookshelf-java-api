package com.enzubis.bookshelf_spring.book;

import com.enzubis.bookshelf_spring.author.Author;
import com.enzubis.bookshelf_spring.bookshelf.Bookshelf;
import com.fasterxml.jackson.annotation.JsonIgnore;

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

    @Column(columnDefinition = "VARCHAR(13)", unique = true)
    private String isbn;

    @ManyToOne
    @JoinColumn(name = "bookshelf_id")
    private Bookshelf bookshelves;

    // int(1 = not done, 2 = reading, 3 = done)
    @Column(name = "reading_status", columnDefinition = " integer default 0")
    private int readingStatus;


    @Column(name = "on_wishlist", columnDefinition = "boolean default false")
    private boolean onWishlist;

    public Book() {
    }

    public Book(String title, Set<Author> authors, String genre, String isbn) {
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


    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getReadingStatus() {
        return readingStatus;
    }

    public void setReadingStatus(int readingStatus) {
        this.readingStatus = readingStatus;
    }

    public boolean isOnWishlist() {
        return onWishlist;
    }

    public void setOnWishlist(boolean onWishlist) {
        this.onWishlist = onWishlist;
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
