package com.enzubis.bookshelf_spring.bookshelf_entry;

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
public class BookshelfEntryConfig {

    @Bean
    CommandLineRunner commandLineRunner(UserRepository userRepository, BookRepository bookRepository) {
        return args -> {
            // Users test data
            User eveline = new User("009BVWKVgHb0ERn3edblbJgAXwI2");
            User bell = new User("AwIfVh5nQge00jnfzxVtwL81tS42");
            User allie = new User("BNPW5oKLRhXD2UG11EpEndBdBzy2");
            User hurleigh = new User("LuApbNIFD4RvdUFAakcAUBu2R6W2");
            User levy = new User("TzOF19jkvPUzEg5rWtrSHQ49Esg2");
            User test1 = new User("pfdHKkSHvJf8pbHnb0OEXcCgY6l1");
            User test2 = new User("rHWb6nUXHRWd3APphm93XBWAJat2");
            User test3 = new User("vtPvNjdbipYw1ZpNTItz773cwLm2");
            User test4 = new User("w2CUnMBB1qRur8aRh8w0uW64fWC2");


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


            Book thrive = new Book("938323406-7", "Thrive", Set.of(zollyGallyon), "2012-07-25", Set.of(drama), macejkovicFeeney);

            Book amazonWomenOnTheMoon = new Book("099315114-0", "Amazon Women on the Moon", Set.of(cathrynEthridge, estevanHackett), "1990-07-25", Set.of(horror, romance),
                    mayertKoepp);

            Book cornIsland = new Book("696409388-5", "Corn Island", Set.of(farahBlaase, estevanHackett, kathyeLindmark), "2004-05-07", Set.of(comedy, drama, musical),
                    friesenAndSons);

            // insert test users into users table
            userRepository.saveAll(
                    List.of(eveline, bell, allie, hurleigh, levy)
            );

            // insert test books into books table
/*            bookRepository.saveAll(
                    List.of(thrive, amazonWomenOnTheMoon, cornIsland)
            );*/
        };
    }
}
