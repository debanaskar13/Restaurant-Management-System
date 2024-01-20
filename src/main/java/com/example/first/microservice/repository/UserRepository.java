package com.example.first.microservice.repository;

import com.example.first.microservice.model.User;
import org.springframework.stereotype.Repository;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {

    List<User> users = new ArrayList<>();

    public String save(User user) {
        users.add(user);
        return "User Added Successfully";
    }

    public List<User> findAll(){return users;}

    public User findById(int userId){
        return users.stream()
                .filter(user -> user.getId() == userId)
                .findAny()
                .orElseThrow(() -> new RuntimeException("User with id "+userId+"not found"));
    }

    public void deleteById(int userId){
        User user = this.findById(userId);
        users.remove(user);
    }

}
