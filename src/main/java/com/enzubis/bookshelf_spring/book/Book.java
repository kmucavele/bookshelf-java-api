package com.enzubis.bookshelf_spring.book;

import com.enzubis.bookshelf_spring.author.Author;
import com.enzubis.bookshelf_spring.book.book_properties.genre.Genre;
import com.enzubis.bookshelf_spring.book.book_properties.publisher.Publisher;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.sql.Date;
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

    // dop - date of publication
    @JsonFormat(pattern = "dd-MM-yyyy")
    @Column(name = "date_of_publication", columnDefinition = "DATE")
    private Date dateOfPublication;

    @OneToMany(mappedBy = "book")
    private Set<Genre> genres = new HashSet<>();

    @ManyToMany(mappedBy = "books")
    private Set<Publisher> publishers = new HashSet<>();

    @Column(columnDefinition = "VARCHAR(13)", unique = true)
    private String isbn;


    public Book() {
    }

    public Book(String title, Set<Author> authors, String dateOfPublication, Set<Genre> genres, Set<Publisher> publishers,
                String isbn) {
        this.title = title;
        this.authors = authors;
        this.dateOfPublication = Date.valueOf(dateOfPublication);
        this.genres = genres;
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

    public Set<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<Author> authors) {
        this.authors.addAll(authors);
    }

    public Set<Publisher> getPublishers() {
        return publishers;
    }

    public void setPublishers(Set<Publisher> publishers) {
        this.publishers = publishers;
    }

    public Set<Genre> getGenres() {
        return genres;
    }

    public void setGenres(Set<Genre> genres) {
        this.genres = genres;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Date getDateOfPublication() {
        return dateOfPublication;
    }

    public void setDateOfPublication(String dateOfPublication) {
        this.dateOfPublication = Date.valueOf(dateOfPublication);
    }

    public void setDateOfPublication(Date dateOfPublication) {
        this.dateOfPublication = dateOfPublication;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", authors=" + authors +
                ", dateOfPublication=" + dateOfPublication +
                ", genres=" + genres +
                ", publishers=" + publishers +
                ", isbn='" + isbn + '\'' +
                '}';
    }
}
