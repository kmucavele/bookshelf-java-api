package com.enzubis.bookshelf_spring.bookshelf_api;

import com.enzubis.bookshelf_spring.book.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping(path = "api/bookshelf")
public class BookshelfController {

    private final BookshelfServices bookshelfServices;

    @Autowired
    public BookshelfController(BookshelfServices bookshelfServices) {
        this.bookshelfServices = bookshelfServices;
    }

    @GetMapping(path = "books")
    public List<Book> getBooks() {
        return bookshelfServices.getBooks();
    }

    @GetMapping(path = "{userId}/books")
    public Set<Bookshelf> getUserBooks(@PathVariable("userId") String userId) {
        bookshelfServices.addBookToUser(userId);
        return bookshelfServices.getUserBooks(userId);
    }
}
