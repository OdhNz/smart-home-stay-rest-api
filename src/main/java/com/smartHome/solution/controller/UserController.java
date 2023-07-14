package com.smartHome.solution.controller;

import com.smartHome.solution.model.User;
import com.smartHome.solution.repository.UserRepository;
import com.smartHome.solution.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<User> registerUser(@RequestBody User user) {
        User savedUser = userService.registerUser(user);
        return ResponseEntity.ok(savedUser);
    }

    @PostMapping("/{userId}/check-in")
    public ResponseEntity<User> checkIn(@PathVariable Long userId) {
        User checkedInUser = userService.checkIn(userId);
        return ResponseEntity.ok(checkedInUser);
    }

    @PostMapping("/{userId}/check-out")
    public ResponseEntity<User> checkOut(@PathVariable Long userId) {
        User checkedOutUser = userService.checkOut(userId);
        return ResponseEntity.ok(checkedOutUser);
    }
}


