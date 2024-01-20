package com.example.first.microservice.controller;

import com.example.first.microservice.dto.UserDto;
import com.example.first.microservice.model.User;
import com.example.first.microservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<?> createUser(@RequestBody UserDto userDto){
        Map<String,String> response = new HashMap<>();
        response.put("message",this.userService.createUser(userDto));
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<?>  getAllUser(){
        Map<String,List<UserDto>> response = new HashMap<>();
        response.put("data",this.userService.getAllUser());
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<?>  getUserById(@PathVariable("userId") int id){
        Map<String,UserDto> response = new HashMap<>();
        response.put("data",this.userService.getUserById(id));
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<?>  deleteUserById(@PathVariable("userId") int id){
        Map<String,String> response = new HashMap<>();
        response.put("message",this.userService.deleteUserById(id));
        return ResponseEntity.ok(response);
    }
}
