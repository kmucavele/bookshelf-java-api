package com.enzubis.bookshelf_spring.bookshelf_entry;

import com.enzubis.bookshelf_spring.book.Book;
import com.enzubis.bookshelf_spring.user.User;
import com.enzubis.bookshelf_spring.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookshelfEntryServices {

    private final BookshelfEntryRepository bookshelfEntryRepository;
    private final UserService userService;

    @Autowired
    public BookshelfEntryServices(BookshelfEntryRepository bookshelfEntryRepository, UserService userService) {
        this.bookshelfEntryRepository = bookshelfEntryRepository;
        this.userService = userService;
    }

    public List<BookshelfEntry> getUserBooks(String userId) throws IllegalStateException {
        User user = userService.getUserByUUID(userId);
        return bookshelfEntryRepository.findBookshelfEntriesByUser(user);
    }

    public void addBookToUser(User user, Book book) {
        Optional<BookshelfEntry> bookshelfEntryOptional = bookshelfEntryRepository
                .findBookshelfEntryByUserAndIsbn(user, book);

        if (bookshelfEntryOptional.isPresent()) {
            throw new IllegalStateException("Book already exists in Bookshelf entries of mentioned user");
        }

        BookshelfEntry bookshelfEntry = new BookshelfEntry();
        bookshelfEntry.setUser(user);
        bookshelfEntry.setIsbn(book);
        bookshelfEntryRepository.save(bookshelfEntry);
    }

    public void deleteBookEntry(User user, Book book) {
        Optional<BookshelfEntry> bookshelfEntryOptional = bookshelfEntryRepository
                .findBookshelfEntryByUserAndIsbn(user, book);

        if(bookshelfEntryOptional.isEmpty()){
            throw new IllegalStateException("No entry for that user and book found");
        }

        bookshelfEntryRepository.delete(bookshelfEntryOptional.get());
    }
}
