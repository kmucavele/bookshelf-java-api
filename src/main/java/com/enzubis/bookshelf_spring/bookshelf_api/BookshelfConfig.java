package com.enzubis.bookshelf_spring.bookshelf_api;

import com.enzubis.bookshelf_spring.book.Book;
import com.enzubis.bookshelf_spring.book.BookRepository;
import com.enzubis.bookshelf_spring.user.User;
import com.enzubis.bookshelf_spring.user.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class BookshelfConfig {

    @Bean
    CommandLineRunner commandLineRunner(UserRepository userRepository, BookRepository bookRepository){
        return args -> {
            User eveline = new User("ce8e8326-624e-4485-8a91-c775ab702a3d");
            User bell = new User("5c9d212e-f85a-4f6c-a046-4df080b0b329");
            User allie = new User("18bbb34c-bb93-437f-bcb1-c7ec6263ede1");
            User hurleigh = new User("e6018640-5181-4fcf-8693-0e6e0ac3ea40");
            User levy = new User("a513f03c-b4b5-462c-8247-4de605d88954");

            userRepository.saveAll(
                    List.of(eveline, bell, allie, hurleigh, levy)
            );
        };
    }
}
