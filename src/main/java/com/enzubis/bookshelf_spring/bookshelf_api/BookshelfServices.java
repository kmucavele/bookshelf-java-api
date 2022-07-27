package com.enzubis.bookshelf_spring.bookshelf_api;

import com.enzubis.bookshelf_spring.author.AuthorService;
import com.enzubis.bookshelf_spring.book.Book;
import com.enzubis.bookshelf_spring.book.BookService;
import com.enzubis.bookshelf_spring.user.User;
import com.enzubis.bookshelf_spring.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class BookshelfServices {

    private final BookshelfRepository bookshelfRepository;

    private final BookService bookService;
    private final AuthorService authorService;
    private final UserService userService;

    @Autowired
    public BookshelfServices(BookshelfRepository bookshelfRepository, BookService bookService,
                             AuthorService authorService, UserService userService) {
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

    public void addBookToUser(String userId) {
        User bell = userService.getUserByUUID(userId);

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


    public Set<Bookshelf> getUserBooks(String userId) {
        return userService.getUserByUUID(userId).getBooks();
    }
}
