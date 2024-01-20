package com.example.first.microservice.controller;

import com.example.first.microservice.model.User;
import com.example.first.microservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public String createUser(@RequestBody User user){
        return userService.createUser(user);
    }

    @GetMapping
    public List<User> getAllUser(){
        return userService.getAllUser();
    }

    @GetMapping("/{userId}")
    public User getUserById(@PathVariable("userId") int id){
        return userService.getUserById(id);
    }

    @DeleteMapping("/{userId}")
    public String deleteUserById(@PathVariable("userId") int id){
        userService.deleteUserById(id);
        return "User deleted successfully";
    }
}
