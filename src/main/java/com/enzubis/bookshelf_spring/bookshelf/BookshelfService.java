package com.enzubis.bookshelf_spring.bookshelf;

import com.enzubis.bookshelf_spring.book.Book;
import com.enzubis.bookshelf_spring.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookshelfService {

    private final BookshelfRepository bookshelfRepository;

    @Autowired
    public BookshelfService(BookshelfRepository bookshelfRepository){
        this.bookshelfRepository = bookshelfRepository;
    }

    public List<Bookshelf> getBookshelves() {
        return bookshelfRepository.findAll();
    }

    public void assignBookToUser(User user, Book book){
        if (bookshelfRepository.existsById(user.getBookshelf().getId())){
            user.getBookshelf().getBooks().add(book);
            bookshelfRepository.save(user.getBookshelf());
            return;
        }

        Bookshelf bookshelf = new Bookshelf();
        user.setBookshelf(bookshelf);
        bookshelf.setUser(user);
        bookshelfRepository.save(bookshelf);
    }
}
