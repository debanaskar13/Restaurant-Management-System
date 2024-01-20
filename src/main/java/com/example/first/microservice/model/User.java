package com.example.first.microservice.model;

import lombok.*;

import java.time.Instant;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    private int id;
    private String username;
    private String password;
    private String email;
    private String firstName;
    private String lastName;
    private Instant registeredAt;
    private Instant lastLoginAt;

}
