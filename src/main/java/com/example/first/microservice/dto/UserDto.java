package com.example.first.microservice.dto;

import com.example.first.microservice.model.Role;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;


@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDto {
    private int id;
    @JsonIgnore
    private String password;
    private String username;
    private String email;
    private String firstName;
    private String middleName;
    private Role role;
    private String lastName;
    private String intro;
    private String profile;
}
