package com.enzubis.bookshelf_spring.bookshelf_entry;

import com.enzubis.bookshelf_spring.book.Book;
import com.enzubis.bookshelf_spring.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BookshelfEntryRepository extends JpaRepository<BookshelfEntry, Long> {

    // TODO: uuid + book_id = primary key
    Optional<BookshelfEntry> findBookshelfEntryByUserAndIsbn(User user, Book book);

    List<BookshelfEntry> findBookshelfEntriesByUser(User user);


}
