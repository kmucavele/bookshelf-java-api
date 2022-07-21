package com.enzubis.bookshelf_spring.bookshelf;

import com.enzubis.bookshelf_spring.book.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookshelfRepository extends JpaRepository<Bookshelf, Long> {
}
