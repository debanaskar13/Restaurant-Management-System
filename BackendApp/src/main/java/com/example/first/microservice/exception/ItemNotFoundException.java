package com.example.first.microservice.exception;

public class ItemNotFoundException extends RuntimeException{

    public ItemNotFoundException(int itemId){
        super("Item with id : "+itemId+" not found");
    }

    public ItemNotFoundException(String message){
        super(message);
    }

}
