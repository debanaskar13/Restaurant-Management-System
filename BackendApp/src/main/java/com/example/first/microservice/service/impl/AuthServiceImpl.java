package com.example.first.microservice.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.example.first.microservice.dto.UserDto;
import com.example.first.microservice.dto.request.AuthRequest;
import com.example.first.microservice.dto.response.AuthResponse;
import com.example.first.microservice.service.AuthService;
import com.example.first.microservice.service.UserService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final ModelMapper modelMapper;
    private final UserService userService;

    @Override
    public AuthResponse signup(UserDto dto) {
        dto.setActive(true);
        String message = this.userService.createUser(dto);
        return AuthResponse.builder().message(message).build();
    }

    @Override
    public AuthResponse login(AuthRequest dto) {

        return null;
    }
}
