package com.example.first.microservice.service;

import com.example.first.microservice.dto.request.AuthRequest;
import com.example.first.microservice.dto.UserDto;
import com.example.first.microservice.dto.response.AuthResponse;

public interface AuthService {

    String signup(UserDto dto);
    String login(AuthRequest dto);

}
