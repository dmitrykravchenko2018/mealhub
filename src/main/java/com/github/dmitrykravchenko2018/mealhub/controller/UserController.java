package com.github.dmitrykravchenko2018.mealhub.controller;

import com.github.dmitrykravchenko2018.mealhub.entity.User;
import com.github.dmitrykravchenko2018.mealhub.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {

    private final UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping(value = "/user")
    public ResponseEntity<User> getUserByName(@RequestParam String username) {
        Optional<User> user = userRepository.findByUsername(username);
        if (user.isPresent()) {
            log.info("Found user :" + user.get());
        } else {
            log.info("User " + username + " not found");
        }
        return ResponseEntity.of(user);
    }

    @GetMapping(value = "/user/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            log.info("Found user :" + user.get());
        } else {
            log.info("User " + id + " not found");
        }
        return ResponseEntity.of(user);
    }

    @PostMapping
    public User newUser(@RequestBody User newUser) {
        return userRepository.save(newUser);
    }

    @DeleteMapping(value = "{id}")
    public void deleteUser(@RequestParam Long id) {
        userRepository.deleteById(id);
    }

    @GetMapping
    public Iterable<User> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users;
    }
}
