package com.enzubis.bookshelf_spring.bookshelf_api;

import com.enzubis.bookshelf_spring.author.AuthorService;
import com.enzubis.bookshelf_spring.book.Book;
import com.enzubis.bookshelf_spring.book.BookService;
import com.enzubis.bookshelf_spring.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookshelfApiServices {

    private final BookService bookService;
    private final AuthorService authorService;
    private final UserService userService;

    @Autowired
    public BookshelfApiServices(BookshelfApiServices bookshelfApiServices, BookService bookService, AuthorService authorService,
                                UserService userService){
        this.bookService = bookService;
        this.userService = userService;
        this.authorService = authorService;
    }

    public List<Book> getBooks() {
        return bookService.getBooks();
    }
}
