package com.enzubis.bookshelf_spring;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.util.concurrent.ExecutionException;


@SpringBootApplication
public class BookshelfSpringApplication {

    public static void main(String[] args) throws IOException, ExecutionException, InterruptedException {
        SpringApplication.run(BookshelfSpringApplication.class, args);
    }
}
