package com.enzubis.bookshelf_spring.book.book_properties.genre;
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

    public Set<Genre> addGenres(Set<Genre> genre){
        Set<Genre> assignSet = new HashSet<>();

        genre.forEach(genreElem -> {
            Optional<Genre> genreOptional = genreRepository.findGenreByGenre(genreElem.getGenre());

            if(genreOptional.isPresent()){
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
