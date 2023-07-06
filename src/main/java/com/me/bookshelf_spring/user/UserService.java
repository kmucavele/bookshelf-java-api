package com.me.bookshelf_spring.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
        Optional<User> userOptional = userRepository.findUserByUuid(uuid);

        if (userOptional.isEmpty()) {
            throw new IllegalStateException("User does not exist. Please register!");
        }

        return userOptional.get();
    }

    public void addUser(User user) {
        Optional<User> userOptional = userRepository.findUserByUuid(user.getUuid());

        if (userOptional.isPresent()) { // TODO: ADD
            throw new IllegalStateException("User already exists!");
        }

        userRepository.save(user);
    }
}
