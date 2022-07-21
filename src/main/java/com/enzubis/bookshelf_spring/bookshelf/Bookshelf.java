package com.enzubis.bookshelf_spring.bookshelf;

import org.springframework.context.annotation.EnableMBeanExport;

import javax.persistence.*;


@Entity
@Table(name = "bookshelves")
public class Bookshelf {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id")
    private int userId;

    @Column(name = "book_id")
    private int bookId;

    @Column(name = "reading_status")
    private int readingStatus;

    @Column(name = "on_wishlist")
    private boolean onWishlist;

    public Bookshelf(){}

    public Bookshelf(int userId, int bookId, int readingStatus, boolean onWishlist) {
        this.userId = userId;
        this.bookId = bookId;
        this.readingStatus = readingStatus;
        this.onWishlist = onWishlist;
    }
}
