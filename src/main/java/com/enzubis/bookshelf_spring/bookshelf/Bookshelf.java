package com.enzubis.bookshelf_spring.bookshelf;

import com.enzubis.bookshelf_spring.book.Book;
import com.enzubis.bookshelf_spring.user.User;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "bookshelves")
public class Bookshelf {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "books_in_bookshelf",
            joinColumns = @JoinColumn(name = "bookshelf_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "book_id", referencedColumnName = "id")
    )
    private Set<Book> books = new HashSet<>();

    @Column(name = "reading_status")
    private int readingStatus;

    @Column(name = "on_wishlist")
    private boolean onWishlist;

    public Bookshelf() {
    }

    public Bookshelf(User userId, Set<Book> books, int readingStatus, boolean onWishlist) {
        this.user = userId;
        this.books = books;
        this.readingStatus = readingStatus;
        this.onWishlist = onWishlist;
    }
}
