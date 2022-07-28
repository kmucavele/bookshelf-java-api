package com.enzubis.bookshelf_spring.book;

import com.enzubis.bookshelf_spring.bookshelf_api.BookshelfServices;
import com.enzubis.bookshelf_spring.user.User;
import com.enzubis.bookshelf_spring.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/books")
public class BookController {

    private final BookshelfServices bookshelfServices;
    private final UserService userService;

    @Autowired
    public BookController(BookshelfServices bookshelfServices, UserService userService) {
        this.bookshelfServices = bookshelfServices;
        this.userService = userService;
    }

    @GetMapping()
    public List<Book> getBooks() {
        return bookshelfServices.getBooks();
    }


    @PostMapping(path = "{userId}/add", consumes = "application/json")
    public void addBook(
            @RequestBody Book book,
            @PathVariable("userId") String userId
    ) {
        System.out.println(book);
        User user = userService.getUserByUUID(userId);
        System.out.println(user.getUuid());
        //bookshelfServices.addBookToUser(user, book);
    }
}
