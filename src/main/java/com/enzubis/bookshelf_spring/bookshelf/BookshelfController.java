package com.enzubis.bookshelf_spring.bookshelf;

import com.enzubis.bookshelf_spring.author.Author;
import com.enzubis.bookshelf_spring.author.AuthorService;
import com.enzubis.bookshelf_spring.book.Book;
import com.enzubis.bookshelf_spring.book.BookService;
import com.enzubis.bookshelf_spring.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/bookshelf")
public class BookshelfController {

    private BookshelfService bookshelfService;
    private BookService bookService;
    private AuthorService authorService;
    private UserService userService;

    @Autowired
    public BookshelfController(BookshelfService bookshelfService, BookService bookService,
                               AuthorService authorService, UserService userService){
        this.bookshelfService = bookshelfService;
        this.bookService = bookService;
        this.userService = userService;
        this.authorService = authorService;
    };

    @GetMapping(path = "books")
    public List<Book> getBooks(){
        return  bookService.getBooks();
    }

    @GetMapping(path = "authors")
    public List<Author> getAuthors(){
        return authorService.getAuthors();
    }

}
