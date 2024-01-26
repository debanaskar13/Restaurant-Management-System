package com.example.first.microservice.service.impl;

import com.example.first.microservice.dto.RoleDto;
import com.example.first.microservice.exception.RoleNotFoundException;
import com.example.first.microservice.model.Role;
import com.example.first.microservice.repository.RoleRepository;
import com.example.first.microservice.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {

    private final ModelMapper modelMapper;
    private final RoleRepository roleRepo;

    @Override
    public List<RoleDto> getAllRoles() {
        return this.roleRepo.findAll()
                .stream()
                .map(role -> this.modelMapper.map(role,RoleDto.class))
                .toList();
    }

    @Override
    public RoleDto getRoleById(int roleId) {
        return this.roleRepo.findById(roleId)
                .map(role -> this.modelMapper.map(role,RoleDto.class))
                .orElseThrow(() -> new RoleNotFoundException(roleId));
    }

    @Override
    public RoleDto getRoleByName(String roleName) {
        return this.roleRepo.findByTitle(roleName)
                .map(role -> modelMapper.map(role, RoleDto.class))
                .orElseThrow(() -> new RoleNotFoundException("Role "+roleName+" not found"));
    }

    @Override
    public String createRole(RoleDto roleDto) {
        Role role = this.modelMapper.map(roleDto, Role.class);
        this.roleRepo.save(role);
        return "Role Created Successfully";
    }

    @Override
    public String updateRole(int roleId, RoleDto roledDto) {
        return null;
    }

    @Override
    public void deleteRoleById(int roleId) {
        this.getRoleById(roleId);
        this.roleRepo.deleteById(roleId);
    }


}
