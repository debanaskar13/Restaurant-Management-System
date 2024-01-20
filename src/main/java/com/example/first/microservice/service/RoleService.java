package com.example.first.microservice.service;

import com.example.first.microservice.dto.RoleDto;

import java.util.List;

public interface RoleService {
    public List<RoleDto> getAllRoles();
    public RoleDto getRoleById(int roleId);
    public RoleDto getRoleByName(String roleName);
    public String createRole(RoleDto roleDto);
    public String updateRole(int roleId,RoleDto roledDto);
    public void deleteRoleById(int roleId);
}
