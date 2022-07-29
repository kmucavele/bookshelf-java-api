package com.enzubis.bookshelf_spring.book;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.SimpleTimeZone;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    // TODO: findByISBN

    Optional<Book> findByIsbn(String isbn);
}
