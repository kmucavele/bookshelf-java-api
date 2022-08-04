package com.enzubis.bookshelf_spring.bookshelf_entry;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class BookshelfEntryId implements Serializable {

    @Column
    private Long book_id;

    @Column
    private String user_id;

    public BookshelfEntryId() {
    }

    public BookshelfEntryId(Long book_id, String user_id) {
        this.book_id = book_id;
        this.user_id = user_id;
    }

    public Long getBook_id() {
        return book_id;
    }

    public void setBook_id(Long book_id) {
        this.book_id = book_id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookshelfEntryId that = (BookshelfEntryId) o;
        return book_id.equals(that.book_id) && user_id.equals(that.user_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(book_id, user_id);
    }
}
