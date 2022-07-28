package com.enzubis.bookshelf_spring.user.bookshelf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/bookshelf")
public class BookshelfController {

    private final BookshelfServices bookshelfServices;

    @Autowired
    public BookshelfController(BookshelfServices bookshelfServices) {
        this.bookshelfServices = bookshelfServices;
    }



/*    @GetMapping(path = "{userId}/books")
    public Set<Bookshelf> getUserBooks(@PathVariable("userId") String userId) {
        bookshelfServices.addBookToUser(userId);
        return bookshelfServices.getUserBooks(userId);
    }*/
}
