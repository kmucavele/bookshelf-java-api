package com.enzubis.bookshelf_spring.bookshelf_api;

import com.enzubis.bookshelf_spring.book.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/bookshelf")
public class BookshelfApiController {

    private final BookshelfApiServices bookshelfApiServices;

    @Autowired
    public BookshelfApiController(BookshelfApiServices bookshelfApiServices) {
        this.bookshelfApiServices = bookshelfApiServices;
    }

    @GetMapping(path = "books")
    public List<Book> getBooks() {
        return bookshelfApiServices.getBooks();
    }

}
