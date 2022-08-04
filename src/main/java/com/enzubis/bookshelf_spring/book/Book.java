package com.enzubis.bookshelf_spring.book;

import com.enzubis.bookshelf_spring.author.Author;
import com.enzubis.bookshelf_spring.book.book_properties.genre.Genre;
import com.enzubis.bookshelf_spring.book.book_properties.publisher.Publisher;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;

import javax.persistence.*;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "books")
public class Book {

    @Id
    @Column(columnDefinition = "VARCHAR(13)", unique = true)
    private String isbn;

    @Column(name = "title")
    private String title;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "book_authors",
            joinColumns = @JoinColumn(name = "isbn", referencedColumnName = "isbn"),
            inverseJoinColumns = @JoinColumn(name = "author_id", referencedColumnName = "id")
    )
    private Set<Author> authors = new HashSet<>();

    // dop - date of publication
    @JsonFormat(pattern = "dd-MM-yyyy")
    @Column(name = "date_of_publication", columnDefinition = "DATE")
    private Date dateOfPublication;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "book_genres",
            joinColumns = @JoinColumn(name = "isbn", referencedColumnName = "isbn"),
            inverseJoinColumns = @JoinColumn(name = "genre_id", referencedColumnName = "id")
    )
    private Set<Genre> genres = new HashSet<>();

    @OneToOne
    @JoinColumn(name = "publisher_id")
    private Publisher publisher;


    public Book() {
    }

    public Book(String isbn, String title, Set<Author> authors, String dateOfPublication, Set<Genre> genres, Publisher publisher) {
        this.isbn = isbn;
        this.title = title;
        this.authors = authors;
        this.dateOfPublication =  Date.valueOf(dateOfPublication);
        this.genres = genres;
        this.publisher = publisher;
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

    @JsonGetter("authors")
    public Set<String> getJsonAuthors() {
        Set<String> jsonAutors = new HashSet<>();
        authors.forEach(author -> jsonAutors.add(author.getName()));
        return jsonAutors;
    }

    public void setAuthors(Set<Author> authors) {
        this.authors.addAll(authors);
    }
/*
    @JsonSetter("authorList")
    public void setAuthorsJson(Set<String> authors){
    }*/

    public Publisher getPublisher() {
        return publisher;
    }

    @JsonGetter("publisher")
    public String getPublisherName() {
        return publisher.getPublisher();
    }

/*    @JsonSetter("publisher")
    public void setPublisherName(String publisher) {
        this.publisher.setPublisher(publisher);
    }*/


    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public Set<Genre> getGenres() {
        return genres;
    }

    @JsonGetter("genres")
    public Set<String> getJsonGenres() {
        Set<String> jsonGenres = new HashSet<>();
        genres.forEach(genre -> jsonGenres.add(genre.getGenre()));
        return jsonGenres;
    }

    public void setGenres(Set<Genre> genres) {
        this.genres = genres;
    }

/*    @JsonSetter("genresList")
    public void setGenresJson(Set<String> genres) {
    }*/

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

    @Override
    public String toString() {
        return "Book{" +
                ", title='" + title + '\'' +
                ", authors=" + authors +
                ", dateOfPublication=" + dateOfPublication +
                ", genres=" + genres +
                ", publisher=" + publisher +
                ", isbn='" + isbn + '\'' +
                '}';
    }
}
