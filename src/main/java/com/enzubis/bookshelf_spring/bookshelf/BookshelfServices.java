package com.enzubis.bookshelf_spring.bookshelf;

import com.enzubis.bookshelf_spring.author.AuthorService;
import com.enzubis.bookshelf_spring.book.Book;
import com.enzubis.bookshelf_spring.book.BookService;
import com.enzubis.bookshelf_spring.user.User;
import com.enzubis.bookshelf_spring.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public void addBookToUser(User user, Book book) {
        Bookshelf bookshelf = new Bookshelf();
        bookshelf.setUser(user);
        bookshelf.setBook_id(book);
        bookshelfRepository.save(bookshelf);
    }


/*    public Set<Bookshelf> getUserBooks(String userId) {
        return userService.getUserByUUID(userId).getBooks();
    }*/


}
