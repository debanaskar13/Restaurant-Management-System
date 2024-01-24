package com.example.first.microservice.service.impl;

import com.example.first.microservice.dto.UserDto;
import com.example.first.microservice.exception.UserNotFoundException;
import com.example.first.microservice.model.Role;
import com.example.first.microservice.model.User;
import com.example.first.microservice.repository.RoleRepository;
import com.example.first.microservice.repository.UserRepository;
import com.example.first.microservice.service.UserService;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.boot.json.GsonJsonParser;
import org.springframework.stereotype.Service;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
        User user = this.userRepo.findById(userId).orElseThrow(() -> new UserNotFoundException(userId));
        modifyUser(user,dto);
        return  "User Updated Successfully";

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

    private User modifyUser(User user,UserDto dto){
        Gson gson = new Gson();
        String userJson = gson.toJson(user);
        String dtoJson = gson.toJson(dto);
        Map<String,Object> userMap = gson.fromJson(userJson, new TypeToken<Map<String, Object>>() {
        }.getType());
        Map<String,Object> dtoMap = gson.fromJson(dtoJson, new TypeToken<Map<String, Object>>() {
        }.getType());

        for(Map.Entry<String,?> entry: userMap.entrySet()){
            String key = entry.getKey();
            Object value = dtoMap.get(key);
            if(value instanceof String && value != null){
                userMap.put(key,value);
            }else if(value instanceof  Integer && Integer.parseInt(value + "") != 0){
                userMap.put(key,value);
            }
        }
        JsonElement jsonElement = gson.toJsonTree(userMap);
        return gson.fromJson(jsonElement, User.class);
    }
}
