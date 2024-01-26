package com.example.first.microservice.exception;

public class RestaurantNotFoundException extends RuntimeException{
    public RestaurantNotFoundException(String message){
        super(message);
    }

    public RestaurantNotFoundException(int restaurantId){
        super("Role with id : "+restaurantId+" not found");
    }

}
