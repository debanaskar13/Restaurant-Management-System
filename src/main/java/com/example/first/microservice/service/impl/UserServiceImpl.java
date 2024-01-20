package com.example.first.microservice.service.impl;

import com.example.first.microservice.dto.UserDto;
import com.example.first.microservice.exception.UserNotFoundException;
import com.example.first.microservice.model.User;
import com.example.first.microservice.repository.UserRepository;
import com.example.first.microservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepo;
    private final ModelMapper modelMapper;


    @Override
    public String createUser(UserDto userDto) {
        User user = this.modelMapper.map(userDto, User.class);
        this.userRepo.save(user);
        return "User Created Successfully";
    }

    @Override
    public List<UserDto> getAllUser() {
        List<User> allUser = this.userRepo.findAll();
        return allUser.stream().map(user -> this.modelMapper.map(user,UserDto.class)).toList();
    }

    @Override
    public UserDto getUserById(int userId) {
        return this.userRepo.findById(userId).map(user -> this.modelMapper.map(user,UserDto.class)).orElseThrow(() -> new UserNotFoundException(userId));
    }

    @Override
    public String updateUserById(int userId, UserDto dto) {
        return null;
    }

    @Override
    public String deleteUserById(int userId) {
        this.getUserById(userId);
        this.userRepo.deleteById(userId);
        return "User Deleted Successfully";
    }
}
