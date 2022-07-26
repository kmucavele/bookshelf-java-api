package com.enzubis.bookshelf_spring.bookshelf_api;

import com.enzubis.bookshelf_spring.author.Author;
import com.enzubis.bookshelf_spring.book.Book;
import com.enzubis.bookshelf_spring.book.BookRepository;
import com.enzubis.bookshelf_spring.book.book_properties.genre.Genre;
import com.enzubis.bookshelf_spring.book.book_properties.publisher.Publisher;
import com.enzubis.bookshelf_spring.user.User;
import com.enzubis.bookshelf_spring.user.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.Set;

@Configuration
public class BookshelfConfig {

    @Bean
    CommandLineRunner commandLineRunner(UserRepository userRepository, BookRepository bookRepository) {
        return args -> {
            // Users test data
            User eveline = new User("ce8e8326-624e-4485-8a91-c775ab702a3d");
            User bell = new User("5c9d212e-f85a-4f6c-a046-4df080b0b329");
            User allie = new User("18bbb34c-bb93-437f-bcb1-c7ec6263ede1");
            User hurleigh = new User("e6018640-5181-4fcf-8693-0e6e0ac3ea40");
            User levy = new User("a513f03c-b4b5-462c-8247-4de605d88954");


            // Authors test data
            Author zollyGallyon = new Author("Zolly Gallyon");
            Author cathrynEthridge = new Author("Cathryn Ethridge");
            Author farahBlaase = new Author("Farah Blaase");
            Author kathyeLindmark = new Author("Kathye Lindmark");
            Author estevanHackett = new Author("Estevan Hackett");

            // Publishers test data
            Publisher macejkovicFeeney = new Publisher("Macejkovic-Feeney");
            Publisher friesenAndSons = new Publisher("Friesen and Sons");
            Publisher prosaccoKirlinAndTorphy = new Publisher("Prosacco, Kirlin and Torphy");
            Publisher kuhnInc = new Publisher("Kuhn Inc");
            Publisher mayertKoepp = new Publisher("Mayert-Koepp");

            // Genres test data
            Genre drama = new Genre("Drama");
            Genre horror = new Genre("Horror");
            Genre comedy = new Genre("Comedy");
            Genre romance = new Genre("Romance");
            Genre musical = new Genre("Musical");


            Book thrive = new Book("Thrive", Set.of(zollyGallyon), "2012-07-25", Set.of(drama),
                    Set.of(macejkovicFeeney), "938323406-7");

            Book amazonWomenOnTheMoon = new Book("Amazon Women on the Moon", Set.of(cathrynEthridge, estevanHackett), "1990-07-25", Set.of(horror, romance),
                    Set.of(kuhnInc, mayertKoepp), "099315114-0");

            Book cornIsland = new Book("Corn Island", Set.of(farahBlaase, estevanHackett, kathyeLindmark), "2004-05-07", Set.of(comedy, drama, musical),
                    Set.of(friesenAndSons), "696409388-5");

            // insert test users into users table
            userRepository.saveAll(
                    List.of(eveline, bell, allie, hurleigh, levy)
            );

            // insert test books into books table
            bookRepository.saveAll(
                    List.of(thrive, amazonWomenOnTheMoon, cornIsland)
            );
        };
    }
}
