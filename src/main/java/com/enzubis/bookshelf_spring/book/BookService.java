package com.enzubis.bookshelf_spring.book;

import com.enzubis.bookshelf_spring.author.Author;
import com.enzubis.bookshelf_spring.book.book_properties.genre.GenreService;
import com.enzubis.bookshelf_spring.book.book_properties.publisher.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    private final BookRepository bookRepository;
    private final PublisherService publisherService;

    private final GenreService genreService;

    @Autowired
    public BookService(BookRepository bookRepository, PublisherService publisherService, GenreService genreService) {
        this.bookRepository = bookRepository;
        this.publisherService = publisherService;
        this.genreService = genreService;
    }

    public List<Book> getBooks() {
        return bookRepository.findAll();
    }

    public void addAuthor(Author author, Book book) {
        book.getAuthors().add(author);
    }

    public Book addBook(Book book){
        Optional<Book> bookOptional = bookRepository.findByIsbn(book.getIsbn());

        if(bookOptional.isPresent()){
            System.out.println("Book " + book.getTitle() + " already exists and will be added to users bookshelf entries");
            return bookOptional.get();
        }

       book.setPublisher(publisherService.addPublisher(book.getPublisher()));
       book.setGenres(genreService.addGenres(book));
       return bookRepository.save(book);
    }

    public Book getBookByIsbn(String isbn){
        Optional<Book> bookOptional = bookRepository.findByIsbn(isbn);

        if(bookOptional.isEmpty()){
            throw new IllegalStateException("Book does not exist");
        }

        return bookOptional.get();
    }
}
