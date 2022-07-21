package com.enzubis.bookshelf_spring.bookshelf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookshelfService {

    private BookshelfRepository bookshelfRepository;

    @Autowired
    public BookshelfService(BookshelfRepository bookshelfRepository){
        this.bookshelfRepository = bookshelfRepository;
    }
}
