package com.enzubis.bookshelf_spring.bookshelf_entry;

import com.enzubis.bookshelf_spring.book.Book;
import com.enzubis.bookshelf_spring.book.BookService;
import com.enzubis.bookshelf_spring.user.User;
import com.enzubis.bookshelf_spring.user.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @ApiOperation(
            value = "Returns the bookshelf entries of a user",
            response = Book.class
    )
    public List<BookshelfEntry> getUserBooks(@PathVariable("userId") String userId) {
        return bookshelfEntryServices.getUserBooks(userId);
    }

    @PostMapping(path = "/{userId}/add", consumes = "application/json")
    @ApiOperation(
            value = "Adds a new book to a user",
            response = Book.class
    )

    public void addBookEntry(
            @RequestBody Book book,
            @PathVariable("userId") String userId) {
        User user = userService.getUserByUUID(userId);
        System.out.println(user);
        System.out.println(book);
        Book addedBook = bookService.addBook(book);
        bookshelfEntryServices.addBookToUser(user, addedBook);
    }

    @DeleteMapping(path = "/{userId}/{isbn}/delete")
    public void deleteBookEntry(@PathVariable("userId") String userId,
                                @PathVariable("isbn") String isbn) {
        User user = userService.getUserByUUID(userId);
        Book book = bookService.getBookByIsbn(isbn);
        bookshelfEntryServices.deleteBookEntry(user, book);
    }
}
