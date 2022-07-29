package com.enzubis.bookshelf_spring.user;

import com.enzubis.bookshelf_spring.bookshelf.Bookshelf;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {

    @Id
    @Column(unique = true, columnDefinition = "VARCHAR(36)")
    private String uuid;

    @OneToMany(mappedBy = "user")
    private Set<Bookshelf> books = new HashSet<>();

    public User() {
    }

    public User(String uuid) {
        this.uuid = uuid;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public Set<Bookshelf> getBooks() {
        return books;
    }

    public void setBooks(Set<Bookshelf> books) {
        this.books = books;
    }


/*    @Override
    public String toString() {
        return "User{" +
                "uuid='" + uuid + '\'' +
                ", books=" + books +
                '}';
    }*/
}
