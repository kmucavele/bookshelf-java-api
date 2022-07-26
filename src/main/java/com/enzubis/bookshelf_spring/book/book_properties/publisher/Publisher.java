package com.enzubis.bookshelf_spring.book.book_properties.publisher;

import javax.persistence.*;

@Entity
@Table(name = "publisher")
public class Publisher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "publisher")
    private String name;

    public Publisher(){}

    public String getPublisher() {
        return name;
    }

    public void setPublisher(String publisher) {
        this.name = publisher;
    }

    @Override
    public String toString() {
        return "Publisher{" +
                "id=" + id +
                ", publisher='" + name + '\'' +
                '}';
    }
}
