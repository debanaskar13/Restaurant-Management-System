package com.example.first.microservice.dto.response;


import com.example.first.microservice.dto.constants.AuthStatus;
import lombok.*;

public record AuthResponse (String jwtToken, AuthStatus status){

}
