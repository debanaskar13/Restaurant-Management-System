package com.example.first.microservice.dto.request;


import lombok.*;

public record AuthRequest (String email,String password){
}
