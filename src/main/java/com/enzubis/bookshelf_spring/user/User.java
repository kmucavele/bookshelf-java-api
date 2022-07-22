package com.enzubis.bookshelf_spring.user;

import com.enzubis.bookshelf_spring.bookshelf.Bookshelf;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String fullName;

    @Column(unique = true)
    private String email;

    @Column(unique = true, columnDefinition = "VARCHAR(36)")
    private String uuid;

    @JsonIgnore
    @OneToOne(mappedBy = "user")
    private Bookshelf bookshelf;

    public User() {
    }

    public User(String username, String fullName, String email, String uuid) {
        this.username = username;
        this.fullName = fullName;
        this.email = email;
        this.uuid = uuid;
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public Bookshelf getBookshelf() {
        return bookshelf;
    }

    public void setBookshelf(Bookshelf bookshelf) {
        this.bookshelf = bookshelf;
    }
}
