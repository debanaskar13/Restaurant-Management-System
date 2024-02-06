package com.example.first.microservice.service.impl;

import com.example.first.microservice.dto.UserDto;
import com.example.first.microservice.dto.request.AuthRequest;
import com.example.first.microservice.dto.response.AuthResponse;
import com.example.first.microservice.service.AuthService;
import com.example.first.microservice.service.UserService;
import com.example.first.microservice.utils.JwtUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final AuthenticationManager authManager;
    private final UserService userService;


    @Override
    public String signup(UserDto dto) {
        if(userService.existsByEmail(dto.getEmail())){
            throw new RuntimeException("User Already Exists !!");
        }
        dto.setActive(true);
        String message = this.userService.createUser(dto);

        return JwtUtils.generateToken(dto.getEmail());

    }

    @Override
    public String login(AuthRequest dto) {
        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(dto.email(), dto.password());
        Authentication authenticate = this.authManager.authenticate(authentication);
        return JwtUtils.generateToken(((UserDetails)(authenticate.getPrincipal())).getUsername());
    }
}
