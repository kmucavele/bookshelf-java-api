package com.enzubis.bookshelf_spring;

import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class SwaggerConfig {
/*    @Bean
    public Docket swaggerConfiguration() {
        return new Docket(DocumentationType.OAS_30)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.enzubis.bookshelf_spring"))
                .build()
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfo(
                "Bookshelf Api",
                "Bookshelf Api - Save, modify or delete your bookshelf entries in a database",
                "1.0",
                "",
                new springfox.documentation.service.Contact("", "", ""),
                "",
                "",
                Collections.emptyList()
        );
    }*/

    @Bean
    public GroupedOpenApi publicApi() {
        return GroupedOpenApi.builder()
                .group("")
                .packagesToScan("com.enzubis.bookshelf_spring")
                .build();
    }
}
