package com.me.bookshelf_spring.bookshelf_entry;

import com.me.bookshelf_spring.book.Book;
import com.me.bookshelf_spring.book.BookService;
import com.me.bookshelf_spring.user.User;
import com.me.bookshelf_spring.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/bookshelf")
public class BookshelfEntryController {

    private final BookshelfEntryServices bookshelfEntryServices;
    private final UserService userService;

    private final BookService bookService;

    @Autowired
    public BookshelfEntryController(BookshelfEntryServices bookshelfEntryServices, UserService userService, BookService bookService) {
        this.bookshelfEntryServices = bookshelfEntryServices;
        this.userService = userService;
        this.bookService = bookService;
    }

    @GetMapping(path = "{userId}")
    public List<BookshelfEntry> getUserBooks(@PathVariable("userId") String userId) {
        return bookshelfEntryServices.getUserBooks(userId);
    }

    @PostMapping(path = "/{userId}/add", consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<String> addBookEntry(
            @RequestBody Book book,
            @PathVariable("userId") String userId) {
        User user = userService.getUserByUUID(userId);
        System.out.println(user);
        System.out.println(book);
        Book addedBook = bookService.addBook(book);
        bookshelfEntryServices.addBookToUser(user, addedBook);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body("The Book " + book.getTitle() + "(isbn: " + book.getIsbn() +
                        ") was added to the bookshelf of: " + userId + '.');
    }

    @DeleteMapping(path = "/{userId}/{isbn}/delete")
    public ResponseEntity<String> deleteBookEntry(@PathVariable("userId") String userId,
                                                  @PathVariable("isbn") String isbn) {
        User user = userService.getUserByUUID(userId);
        Book book = bookService.getBookByIsbn(isbn);
        bookshelfEntryServices.deleteBookEntry(user, book);

        return ResponseEntity.status(HttpStatus.OK)
                .body("The Book " + book.getTitle() + "(isbn: " + isbn +
                        ") was removed from the bookshelf of: " + userId + '.');
    }

    @PatchMapping(path = "{userId}/{isbn}")
    public ResponseEntity<String> updateBookEntry(
            @PathVariable("userId") String userId,
            @PathVariable("isbn") String isbn,
            @RequestParam(required = false) Optional<Boolean> wishlist,
            @RequestParam(required = false) Optional<Integer> status
    ) {

        User user = userService.getUserByUUID(userId);
        Book book = bookService.getBookByIsbn(isbn);

        wishlist.ifPresent(wishlistUpdate -> bookshelfEntryServices
                .updateBookshelfEntryOnWishlist(user, book, wishlistUpdate));

        status.ifPresent(readingStatus -> bookshelfEntryServices
                .updateBookshelfEntryReadingStatus(user, book, readingStatus));

        if (wishlist.isEmpty() && status.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Please set an update value");
        } else {
            return ResponseEntity.status(HttpStatus.OK)
                    .body("Update was successful");
        }
    }
}
