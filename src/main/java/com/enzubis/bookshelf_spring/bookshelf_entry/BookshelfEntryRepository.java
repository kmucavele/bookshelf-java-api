package com.enzubis.bookshelf_spring.bookshelf_entry;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BookshelfEntryRepository extends JpaRepository<BookshelfEntry, Long> {

    // TODO: uuid + book_id = primary key
}
