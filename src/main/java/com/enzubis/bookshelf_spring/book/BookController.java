package com.enzubis.bookshelf_spring.book;

import com.enzubis.bookshelf_spring.bookshelf_entry.BookshelfEntryServices;
import com.enzubis.bookshelf_spring.user.User;
import com.enzubis.bookshelf_spring.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/books")
public class BookController {

    private final BookshelfEntryServices bookshelfEntryServices;
    private final UserService userService;
    private final BookService bookService;


    @Autowired
    public BookController(BookshelfEntryServices bookshelfEntryServices, UserService userService, BookService bookService) {
        this.bookshelfEntryServices = bookshelfEntryServices;
        this.userService = userService;
        this.bookService = bookService;
    }

    @GetMapping()
    public List<Book> getBooks() {
        return bookshelfEntryServices.getBooks();
    }


    @PostMapping(path = "/{userId}/add", consumes = "application/json")
    public void addBook(
            @RequestBody Book book,
            @PathVariable("userId") String userId
    ) {
        User user = userService.getUserByUUID(userId);
        System.out.println(user);
        System.out.println(book);
        Book addedBook = bookService.addBook(book);
        bookshelfEntryServices.addBookToUser(user, addedBook);
    }
}
