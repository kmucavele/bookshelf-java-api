package com.enzubis.bookshelf_spring.user.bookshelf;

import com.enzubis.bookshelf_spring.book.Book;
import com.enzubis.bookshelf_spring.user.User;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "bookshelf")
public class Bookshelf {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "user_uuid")
    private User user;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

    // int(1 = not done, 2 = reading, 3 = done)
    @Column(name = "reading_status", columnDefinition = "integer default 0")
    private int readingStatus;

    @Column(name = "on_wishlist", columnDefinition = "boolean default false")
    private boolean onWishlist;


    public Bookshelf() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    @Override
    public String toString() {
        return "Bookshelf{" +
                "id=" + id +
                ", user=" + user +
                ", book=" + book +
                ", readingStatus=" + readingStatus +
                ", onWishlist=" + onWishlist +
                '}';
    }
}
