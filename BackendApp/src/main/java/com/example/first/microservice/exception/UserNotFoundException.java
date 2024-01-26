package com.example.first.microservice.exception;

public class UserNotFoundException extends RuntimeException{

    public UserNotFoundException(String message){
        super(message);
    }

    public UserNotFoundException(int userId){
        super("User with id : "+userId+" not found");
    }

}
