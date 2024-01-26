package com.example.first.microservice.dto;

import com.example.first.microservice.model.User;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;

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
