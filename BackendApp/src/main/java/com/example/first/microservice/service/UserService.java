package com.example.first.microservice.service;

import java.util.List;

import com.example.first.microservice.dto.UserDto;
import com.example.first.microservice.dto.UserUpdateDto;

public interface UserService {

    public String createUser(UserDto user);

    public List<UserDto> getAllUser();

    public UserDto getUserById(int userId);

    public String updateUserById(int userId, UserUpdateDto dto);

    public String deleteUserById(int userId);

    public boolean existsByEmail(String email);
}
