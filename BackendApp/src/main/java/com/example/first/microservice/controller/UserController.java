package com.example.first.microservice.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.first.microservice.dto.UserDto;
import com.example.first.microservice.dto.UserUpdateDto;
import com.example.first.microservice.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(path = "/users")
@RequiredArgsConstructor
@PreAuthorize("hasAuthority('ADMIN')")
public class UserController {

    private final UserService userService;

    @PostMapping("/create")
    public ResponseEntity<?> createUser(@RequestBody UserDto userDto) {
        Map<String, String> response = new HashMap<>();
        response.put("message", this.userService.createUser(userDto));
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<?> getAllUser() {
        Map<String, List<UserDto>> response = new HashMap<>();
        response.put("data", this.userService.getAllUser());
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<?> getUserById(@PathVariable("userId") int id) {
        Map<String, UserDto> response = new HashMap<>();
        response.put("data", this.userService.getUserById(id));
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{userId}")
    public ResponseEntity<?> updateUser(@PathVariable int userId, @RequestBody UserUpdateDto userDto) {
        Map<String, String> response = new HashMap<>();
        response.put("message", this.userService.updateUserById(userId, userDto));
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<?> deleteUserById(@PathVariable("userId") int id) {
        Map<String, String> response = new HashMap<>();
        response.put("message", this.userService.deleteUserById(id));
        return ResponseEntity.ok(response);
    }
}
