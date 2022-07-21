package com.enzubis.bookshelf_spring.bookshelf;

import com.enzubis.bookshelf_spring.user.User;

import javax.persistence.*;


@Entity
@Table(name = "bookshelves")
public class Bookshelf {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @Column(name = "book_id")
    private int bookId;

    @Column(name = "reading_status")
    private int readingStatus;

    @Column(name = "on_wishlist")
    private boolean onWishlist;

    public Bookshelf() {
    }

    public Bookshelf(User userId, int bookId, int readingStatus, boolean onWishlist) {
        this.user = userId;
        this.bookId = bookId;
        this.readingStatus = readingStatus;
        this.onWishlist = onWishlist;
    }
}
