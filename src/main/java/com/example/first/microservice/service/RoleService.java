package com.example.first.microservice.service;

import com.example.first.microservice.dto.RoleDto;

import java.util.List;

public interface RoleService {
    public List<RoleDto> getAllRoles();
    public RoleDto getRoleById();
    public RoleDto getRoleByName();
    public String createRole();
    public String updateRole();
    public void deleteRole();
}
