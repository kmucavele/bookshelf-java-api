package com.me.bookshelf_spring.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    //User findUserByUuid(String uuid);
    Optional<User> findUserByUuid(String uuid);
}
