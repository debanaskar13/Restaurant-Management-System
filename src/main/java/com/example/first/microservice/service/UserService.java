package com.example.first.microservice.service;

import com.example.first.microservice.dto.UserUpdateDto;
import com.example.first.microservice.model.User;
import com.example.first.microservice.dto.UserDto;

import java.util.List;

public interface UserService {

    public String createUser(UserDto user);

    public List<UserDto> getAllUser();

    public UserDto getUserById(int userId);

    public String updateUserById(int userId, UserUpdateDto dto);

    public String deleteUserById(int userId);
}
