package com.example.first.microservice.controller;

import com.example.first.microservice.dto.UserDto;
import com.example.first.microservice.dto.request.AuthRequest;
import com.example.first.microservice.service.AuthService;

import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<?> signup(@RequestBody UserDto dto) {
        return ResponseEntity.ok(this.authService.signup(dto));
    }

    @PostMapping("/login")
    public ResponseEntity<?> postMethodName(@RequestBody AuthRequest authRequest) {
        var response = this.authService.login(authRequest);
        return ResponseEntity.ok(response);
    }

}
