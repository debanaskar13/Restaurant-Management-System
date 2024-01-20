package com.example.first.microservice.service;

import com.example.first.microservice.model.User;
import com.example.first.microservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public String createUser(User user) {
        return userRepository.save(user);
    }

    public List<User> getAllUser(){
        return this.userRepository.findAll();
    }

    public User getUserById(int userId){
        return this.userRepository.findById(userId);
    }

    public void deleteUserById(int userId){
        this.userRepository.deleteById(userId);
    }
}
