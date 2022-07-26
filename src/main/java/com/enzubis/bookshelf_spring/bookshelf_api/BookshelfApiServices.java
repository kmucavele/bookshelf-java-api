package com.enzubis.bookshelf_spring.bookshelf_api;

import com.enzubis.bookshelf_spring.author.AuthorService;
import com.enzubis.bookshelf_spring.book.Book;
import com.enzubis.bookshelf_spring.book.BookService;
import com.enzubis.bookshelf_spring.user.User;
import com.enzubis.bookshelf_spring.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookshelfApiServices {

    private final BookshelfRepository bookshelfRepository;

    private final BookService bookService;
    private final AuthorService authorService;
    private final UserService userService;

    @Autowired
    public BookshelfApiServices(BookshelfRepository bookshelfRepository, BookService bookService,
                                AuthorService authorService, UserService userService){
        this.bookshelfRepository = bookshelfRepository;
        this.bookService = bookService;
        this.userService = userService;
        this.authorService = authorService;
    }

    public List<Book> getBooks() {
        return bookService.getBooks();
    }

    public List<User> getUsers() {
        return userService.getUsers();
    }

    public void addBookToUser(){
        User bell = getUserByUUID("5c9d212e-f85a-4f6c-a046-4df080b0b329");
        Book amazonWomenOnTheMoon = bookService.getBooks().get(1);
        Book cornIsland = bookService.getBooks().get(2);
        Bookshelf bookshelf = new Bookshelf();
        Bookshelf bookshelf1 = new Bookshelf();
        bookshelf.setBook(cornIsland);
        bookshelf1.setBook(amazonWomenOnTheMoon);
        bookshelf1.setUser(bell);
        bookshelf.setUser(bell);
        bookshelfRepository.saveAll(List.of(bookshelf1, bookshelf));
    }

    public User getUserByUUID(String uuid) {
        return userService.getUserByUUID(uuid);
    }
}
