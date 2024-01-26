package com.example.first.microservice.exception;

public class RoleNotFoundException extends RuntimeException{

    public RoleNotFoundException(String message){
        super(message);
    }

    public RoleNotFoundException(int roleId){
        super("Role with id : "+roleId+" not found");
    }


}
