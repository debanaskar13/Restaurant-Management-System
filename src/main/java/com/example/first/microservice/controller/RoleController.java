package com.example.first.microservice.controller;

import com.example.first.microservice.dto.RoleDto;
import com.example.first.microservice.service.RoleService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/roles")
@RequiredArgsConstructor
public class RoleController {

    private final RoleService roleService;

    @PostMapping
    public ResponseEntity<?> createRole(@RequestBody @Valid RoleDto roleDto){
        System.out.println(roleDto);
        Map<String, String> response = new HashMap<>();
        response.put("message",this.roleService.createRole(roleDto));
        return ResponseEntity.ok(response);

    }

    @GetMapping
    public ResponseEntity<?> getAllRoles(){
        Map<String, List<RoleDto>> response = new HashMap<>();
        response.put("data",this.roleService.getAllRoles());
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{roleId}")
    public ResponseEntity<?> getRoleById(@PathVariable("roleId") int roleId){
        Map<String, RoleDto> response = new HashMap<>();
        response.put("data",this.roleService.getRoleById(roleId));
        return ResponseEntity.ok(response);
    }

    @GetMapping("/name/{role}")
    public ResponseEntity<?> getRoleByName(@PathVariable("role") String roleName){
        Map<String, RoleDto> response = new HashMap<>();
        response.put("data",this.roleService.getRoleByName(roleName));
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{roleId}")
    public ResponseEntity<?> updateRole(@PathVariable("roleId") int roleId,@RequestBody RoleDto roleDto){
        return ResponseEntity.ok("Working in progress");
    }


    @DeleteMapping("/{roleId}")
    public ResponseEntity<?> deleteRoleById(@PathVariable("roleId") int roleId){
        Map<String, String> response = new HashMap<>();
        this.roleService.deleteRoleById(roleId);
        response.put("data","Role Deleted Successfully");
        return ResponseEntity.ok(response);
    }



}
