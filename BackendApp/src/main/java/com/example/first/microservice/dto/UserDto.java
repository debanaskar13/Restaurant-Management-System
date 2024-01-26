package com.example.first.microservice.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.Instant;


@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDto {
    private int id;

    @NotBlank(message = "username can't be empty")
    @NotNull(message = "username can't be Null")
    @Size(min = 3,max = 30,message = "username should be within minimum 5 and maximum 30 characters")
    private String username;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @NotBlank(message = "Password can't be empty")
    @NotNull(message = "Password can't be Null")
    @Size(min = 6,max = 50,message = "Password should be within minimum 6 and maximum 50 characters")
    private String password;

    @NotBlank(message = "Email can't be empty")
    @NotNull(message = "Email can't be Null")
    @Email(message = "Please enter a valid Email Address")
    private String email;

    @NotBlank(message = "First Name can't be empty")
    @NotNull(message = "First Name can't be Null")
    @Size(min = 3,max = 50,message = "First Name should be within minimum 3 and maximum 50 characters")
    private String firstName;

    private String middleName;
    private String role;

    @NotBlank(message = "Last Name can't be empty")
    @NotNull(message = "Last Name can't be Null")
    @Size(min = 3,max = 50,message = "Last Name should be within minimum 3 and maximum 50 characters")
    private String lastName;

    @NotBlank(message = "Mobile Number can't be empty")
    @NotNull(message = "Mobile Number can't be Null")
    @Size(min = 10,max = 10,message = "Mobile Number should be 10 digits")
    private String mobileNumber;

    private String intro;
    private String profile;

    private Instant registeredAt;
    private Instant lastLoginAt;
}