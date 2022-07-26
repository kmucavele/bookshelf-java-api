package com.enzubis.bookshelf_spring.bookshelf_api;

import com.enzubis.bookshelf_spring.book.Book;
import com.enzubis.bookshelf_spring.user.User;

import javax.persistence.*;

@Entity
@Table(name = "bookshelf")
public class Bookshelf {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // int(1 = not done, 2 = reading, 3 = done)
    @Column(name = "reading_status", columnDefinition = "integer default 0")
    private int readingStatus;

    @Column(name = "on_wishlist", columnDefinition = "boolean default false")
    private boolean onWishlist;

    @ManyToOne
    @JoinColumn(name = "user_uuid")
    private User user;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

    public Bookshelf(){}

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
}
