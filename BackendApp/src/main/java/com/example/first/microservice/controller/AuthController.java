package com.example.first.microservice.controller;

import com.example.first.microservice.dto.UserDto;
import com.example.first.microservice.dto.constants.AuthStatus;
import com.example.first.microservice.dto.request.AuthRequest;
import com.example.first.microservice.dto.response.AuthResponse;
import com.example.first.microservice.service.AuthService;

import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

        try{
            String jwtToken = this.authService.signup(dto);
            AuthResponse authResponse = new AuthResponse(jwtToken, AuthStatus.USER_CREATED_SUCCESSFULLY);
            return ResponseEntity.status(HttpStatus.CREATED).body(authResponse);
        }catch(RuntimeException ex) {
            AuthResponse authResponse = new AuthResponse(null, AuthStatus.USER_NOT_CREATED);
            return ResponseEntity.status(HttpStatus.CONFLICT).body(authResponse);
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> postMethodName(@RequestBody AuthRequest authRequest) {
        try{
            var jwtToken = this.authService.login(authRequest);
            AuthResponse authResponse = new AuthResponse(jwtToken, AuthStatus.LOGIN_SUCCESS);
            return ResponseEntity.status(HttpStatus.OK).body(authResponse);
        }catch(Exception ex){
            AuthResponse authResponse = new AuthResponse(null, AuthStatus.LOGIN_FAILED);
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(authResponse);
        }
    }

}
