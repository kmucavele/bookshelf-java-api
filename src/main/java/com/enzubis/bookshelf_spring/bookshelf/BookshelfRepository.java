package com.enzubis.bookshelf_spring.bookshelf;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BookshelfRepository extends JpaRepository<Bookshelf, Long> {

    // TODO: uuid + book_id = primary key
}
