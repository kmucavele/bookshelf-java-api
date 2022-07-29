package com.enzubis.bookshelf_spring.book;

import com.enzubis.bookshelf_spring.author.Author;
import com.enzubis.bookshelf_spring.book.book_properties.publisher.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    private final BookRepository bookRepository;
    private final PublisherService publisherService;

    @Autowired
    public BookService(BookRepository bookRepository, PublisherService publisherService) {
        this.bookRepository = bookRepository;
        this.publisherService = publisherService;
    }

    public List<Book> getBooks() {
        return bookRepository.findAll();
    }

    public void addAuthor(Author author, Book book) {
        book.getAuthors().add(author);
    }

    public void addBook(Book book){
        // TODO: testen ob book_id == null
        Optional<Book> bookOptional = bookRepository.findByIsbn(book.getIsbn());

        if(bookOptional.isPresent()){
            throw new IllegalStateException("Book " + book.getTitle() + " already exists!");
        };

        book.setPublisher(publisherService.addPublisherId(book.getPublisher()));
        //book.setGenres();
        bookRepository.save(book);
    }
}
