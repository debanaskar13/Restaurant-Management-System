package com.example.first.microservice.repository;

import com.example.first.microservice.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role,Integer> {
    public Optional<Role> findByTitle(String title);
}
