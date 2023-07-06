package com.me.bookshelf_spring.book;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/books")
public class BookController {

    public final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public List<Book> getBooks() {
        return bookService.getBooks();
    }

    @PostMapping(path = "addBooks")
    public ResponseEntity<String> add(@RequestBody List<Book> books){
        bookService.addBooks(books);
        return new ResponseEntity<>("Books were added", HttpStatus.OK);
    }

    @PostMapping(path = "addBook")
    public ResponseEntity<String> add(@RequestBody Book book){
        bookService.addBook(book);
        return new ResponseEntity<>("Book was added", HttpStatus.OK);
    }
}
