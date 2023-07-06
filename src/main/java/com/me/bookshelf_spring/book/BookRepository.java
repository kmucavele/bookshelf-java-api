package com.me.bookshelf_spring.book;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    // TODO: findByISBN
    List<Book> findAll();

    Optional<Book> findByIsbn(String isbn);
}
