package com.example.first.microservice.service.impl;

import com.example.first.microservice.dto.UserDto;
import com.example.first.microservice.exception.UserNotFoundException;
import com.example.first.microservice.model.Role;
import com.example.first.microservice.model.User;
import com.example.first.microservice.repository.RoleRepository;
import com.example.first.microservice.repository.UserRepository;
import com.example.first.microservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepo;
    private final ModelMapper modelMapper;
    private final RoleRepository roleRepo;


    @Override
    public String createUser(UserDto userDto) {
        User user = this.userDtoToUser(userDto);
        Optional<Role> userRole = this.roleRepo.findByTitle(userDto.getRole());
        if(userRole.isPresent()){
            user.setRole(userRole.get());
        }else{
            userRole = this.roleRepo.findByTitle("USER");
            user.setRole(userRole.get());
        }
        this.userRepo.save(user);
        return "User Created Successfully";
    }

    @Override
    public List<UserDto> getAllUser() {
        List<User> allUser = this.userRepo.findAll();
        return allUser.stream().map(this::userToUserDto).toList();
    }

    @Override
    public UserDto getUserById(int userId) {
        return this.userRepo.findById(userId).map(this::userToUserDto).orElseThrow(() -> new UserNotFoundException(userId));
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

    private User userDtoToUser(UserDto dto){
        return this.modelMapper.map(dto, User.class);
    }

    private UserDto userToUserDto(User user){
        UserDto dto = this.modelMapper.map(user, UserDto.class);
        dto.setRole(user.getRole().getTitle());
        return dto;
    }
}
