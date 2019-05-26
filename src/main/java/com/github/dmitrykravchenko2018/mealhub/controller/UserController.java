package com.github.dmitrykravchenko2018.mealhub.controller;

import com.github.dmitrykravchenko2018.mealhub.entity.User;
import com.github.dmitrykravchenko2018.mealhub.repository.UserRepository;
import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
@Api(tags = "users")
@Slf4j
public class UserController {

    private final UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping(value = "/user")
    @ApiOperation(value = "${UserController.getUserByName}")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Something went wrong"),
            @ApiResponse(code = 403, message = "Access denied"),
            @ApiResponse(code = 404, message = "The user doesn't exist")})
    public ResponseEntity<User> getUserByName(@ApiParam("Username")  @RequestParam String username) {
        Optional<User> user = userRepository.findByUsername(username);
        if (user.isPresent()) {
            log.info("Found user :" + user.get());
        } else {
            log.info("User " + username + " not found");
        }
        return ResponseEntity.of(user);
    }

    @GetMapping(value = "/user/{id}")
    @ApiOperation(value = "${UserController.getUserById}")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Something went wrong"),
            @ApiResponse(code = 403, message = "Access denied"),
            @ApiResponse(code = 404, message = "The user doesn't exist")})
    public ResponseEntity<User> getUserById(@ApiParam("User Id") @PathVariable Long id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            log.info("Found user :" + user.get());
        } else {
            log.info("User " + id + " not found");
        }
        return ResponseEntity.of(user);
    }

    @PostMapping
    @ApiOperation(value = "${UserController.newUser}")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Something went wrong"),
            @ApiResponse(code = 403, message = "Access denied")})
    public User newUser(@ApiParam("New User") @RequestBody User newUser) {
        return userRepository.save(newUser);
    }

    @DeleteMapping(value = "{id}")
    @ApiOperation(value = "${UserController.deleteUser}")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Something went wrong"),
            @ApiResponse(code = 403, message = "Access denied")})
    public void deleteUser(@ApiParam("User Id") @RequestParam Long id) {
        userRepository.deleteById(id);
    }

    @GetMapping
    @ApiOperation(value = "${UserController.getAllUsers}")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Something went wrong"),
            @ApiResponse(code = 403, message = "Access denied")})
    public Iterable<User> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users;
    }
}
