package com.spring.springuser.controller;

import com.spring.springuser.request.UserRequestDTO;
import com.spring.springuser.response.UserResponseDTO;
import com.spring.springuser.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(path = "/users")
    public void createUsers(@RequestBody UserRequestDTO userRequestDTO) {
        userService.createUser(userRequestDTO);
    }

    @GetMapping(path = "/users/{userId}")
    public ResponseEntity<UserResponseDTO> retrieveUser(@PathVariable Long userId) {
        return ResponseEntity.ok(userService.retrieveUser(userId));
    }

    @GetMapping(path = "/users")
    public ResponseEntity<List<UserResponseDTO>> retrieveAllUsers() {
        return ResponseEntity.ok(userService.retrieveAllUsers());
    }

    @DeleteMapping(path = "/users/{userId}")
    public void deleteUser(@PathVariable Long userId) {
        userService.deleteUser(userId);
    }

    @PutMapping(path = "/users/{userId}")
    public void updateUser(@PathVariable Long userId,
                           @RequestBody UserRequestDTO requestDTO) {
        userService.updateUser(userId, requestDTO);
    }

    @GetMapping(path = "/users/{userId}/posts")
    public ResponseEntity<UserResponseDTO> getPostsByUserId(@PathVariable Long userId) {
        return ResponseEntity.ok(userService.getPostsByUserId(userId));
    }
}
