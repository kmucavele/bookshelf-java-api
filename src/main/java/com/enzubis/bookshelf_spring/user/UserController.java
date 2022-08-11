package com.enzubis.bookshelf_spring.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getUsers() {
        return userService.getUsers();
    }

    @PostMapping(path = "/add")
    public ResponseEntity<String> addUser(@RequestBody User user) {
        userService.addUser(user);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body("User with uuid: " + user.getUuid() + " was registered.");
    }
}
