package com.enzubis.bookshelf_spring.user.bookshelf;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BookshelfRepository extends JpaRepository<Bookshelf, Long> {
}
