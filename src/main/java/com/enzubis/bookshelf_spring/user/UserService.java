package com.enzubis.bookshelf_spring.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public User getUserByUUID(String uuid) {
        User user = userRepository.findUserByUuid(uuid);

        try {
            return user;
        } catch (NullPointerException e) {
            throw new IllegalStateException("User does not exist! Please register first.");
        }
    }

    public void addUser(String uuid) {
        User user = userRepository.findUserByUuid(uuid);

        try {

            userRepository.save(user);
        } catch (NullPointerException e) {
            throw new IllegalStateException("User already exists!");
        }
    }
}
