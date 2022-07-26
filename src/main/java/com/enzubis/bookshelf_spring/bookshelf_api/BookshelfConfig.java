package com.enzubis.bookshelf_spring.bookshelf_api;

import com.enzubis.bookshelf_spring.book.BookRepository;
import com.enzubis.bookshelf_spring.user.User;
import com.enzubis.bookshelf_spring.user.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BookshelfConfig {

    @Bean
    CommandLineRunner commandLineRunner(UserRepository userRepository, BookRepository bookRepository){
        return args -> {
        };
    }
}
