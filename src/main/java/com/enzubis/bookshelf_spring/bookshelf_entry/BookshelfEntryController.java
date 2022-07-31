package com.enzubis.bookshelf_spring.bookshelf_entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/bookshelf")
public class BookshelfEntryController {

    private final BookshelfEntryServices bookshelfEntryServices;

    @Autowired
    public BookshelfEntryController(BookshelfEntryServices bookshelfEntryServices) {
        this.bookshelfEntryServices = bookshelfEntryServices;
    }



/*    @GetMapping(path = "{userId}/books")
    public Set<Bookshelf> getUserBooks(@PathVariable("userId") String userId) {
        bookshelfServices.addBookToUser(userId);
        return bookshelfServices.getUserBooks(userId);
    }*/
}
