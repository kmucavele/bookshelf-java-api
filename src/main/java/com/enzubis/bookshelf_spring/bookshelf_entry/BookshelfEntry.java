package com.enzubis.bookshelf_spring.bookshelf_entry;

import com.enzubis.bookshelf_spring.book.Book;
import com.enzubis.bookshelf_spring.user.User;

import javax.persistence.*;

@Entity
@Table(name = "bookshelf_entry")
public class BookshelfEntry {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_uuid")
    private User user;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book_id;

    // int(1 = not done, 2 = reading, 3 = done)
    @Column(name = "reading_status", columnDefinition = "integer default 0")
    private int readingStatus;

    @Column(name = "on_wishlist", columnDefinition = "boolean default false")
    private boolean onWishlist;


    public BookshelfEntry() {
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

    public Book getBook_id() {
        return book_id;
    }

    public void setBook_id(Book book_id) {
        this.book_id = book_id;
    }

/*    @Override
    public String toString() {
        return "Bookshelf{" +
                "id=" + id +
                ", user=" + user +
                ", book_id=" + book_id +
                ", readingStatus=" + readingStatus +
                ", onWishlist=" + onWishlist +
                '}';
    }*/
}
