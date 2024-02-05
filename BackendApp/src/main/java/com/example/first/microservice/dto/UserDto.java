package com.example.first.microservice.dto;

import java.time.Instant;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDto {
    private int id;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @NotBlank(message = "Password can't be empty")
    @NotNull(message = "Password can't be Null")
    @Size(min = 6, max = 50, message = "Password should be within minimum 6 and maximum 50 characters")
    private String password;

    @NotBlank(message = "Email can't be empty")
    @NotNull(message = "Email can't be Null")
    @Email(message = "Please enter a valid Email Address")
    private String email;

    @NotBlank(message = "First Name can't be empty")
    @NotNull(message = "First Name can't be Null")
    @Size(min = 3, max = 50, message = "First Name should be within minimum 3 and maximum 50 characters")
    private String firstName;

    private String role;

    @NotBlank(message = "Last Name can't be empty")
    @NotNull(message = "Last Name can't be Null")
    @Size(min = 3, max = 50, message = "Last Name should be within minimum 3 and maximum 50 characters")
    private String lastName;

    private String mobileNumber;

    private String intro;
    private String profile;
    private boolean active;

    private Instant registeredAt;
    private Instant lastLoginAt;
}
