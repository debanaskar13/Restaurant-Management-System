package com.example.first.microservice.dto;

import java.time.Instant;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class RestaurantDto {

    private int id;
    private String name;
    private String address;
    private String phoneNumber;
    private String email;
    private UserDto manager;
    private Instant createdAt;
    private Instant updatedAt;
}
