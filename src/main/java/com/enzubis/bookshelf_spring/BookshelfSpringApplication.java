package com.enzubis.bookshelf_spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;


@SpringBootApplication
@EnableSwagger2
public class BookshelfSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookshelfSpringApplication.class, args);
    }

    @Bean
    public Docket swaggerConfiguration() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.enzubis.bookshelf_spring"))
                .build()
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfo(
                "Bookshelf Api",
                "Bookshelf Api - Save, modify or delete your bookshelf entries in a database",
                "",
                "",
                new springfox.documentation.service.Contact("", "", ""),
                "",
                "",
                Collections.emptyList()
        );
    }
}
