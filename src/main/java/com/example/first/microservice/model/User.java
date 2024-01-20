package com.example.first.microservice.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.Instant;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "username",nullable = false,unique = true)
    private String username;

    @Column(name = "password",nullable = false)
    private String password;

    @Column(name = "email",nullable = false,unique = true)
    private String email;

    @Column(name = "first_name",nullable = false)
    private String firstName;

    @Column(name = "middle_name")
    private String middleName;

    @Column(name = "last_name",nullable = false)
    private String lastName;

    @Column(name = "mobile_number",unique = true)
    private String mobileNumber;

    @Column(name = "intro")
    private String intro;

    @Column(name = "profile")
    private String profile;

    @Column(name = "registered_at",nullable = false)
    @CreatedDate
    private Instant registeredAt;

    @Column(name = "last_login_at",nullable = false)
    @LastModifiedDate
    private Instant lastLoginAt;

}
