package com.me.bookshelf_spring.genre;

import com.me.bookshelf_spring.book.Book;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class GenreService {
    final GenreRepository genreRepository;

    public GenreService(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    public Set<Genre> addGenres(Book book) {
        Set<Genre> bookGenre = book.getGenres();
        Set<Genre> assignSet = new HashSet<>();
        bookGenre.forEach(genreElem -> {
            Optional<Genre> genreOptional = genreRepository.findGenreByGenre(genreElem.getGenre());

            if (genreOptional.isPresent()) {
                assignSet.add(genreOptional.get());
            } else {
                Genre newGenre = new Genre(genreElem.getGenre());
                genreRepository.save(newGenre);
                assignSet.add(newGenre);
            }
        });

        return assignSet;
    }
}
