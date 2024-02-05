package com.example.first.microservice.service;

import com.example.first.microservice.dto.request.AuthRequest;
import com.example.first.microservice.dto.UserDto;
import com.example.first.microservice.dto.response.AuthResponse;

public interface AuthService {

    AuthResponse signup(UserDto dto);
    AuthResponse login(AuthRequest dto);

}
