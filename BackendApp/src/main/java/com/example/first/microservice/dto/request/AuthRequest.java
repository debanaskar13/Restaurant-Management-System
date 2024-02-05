package com.example.first.microservice.dto.request;


import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class AuthRequest {

    private String email;
    private String password;


}
