package com.example.first.microservice.exception;

public class IngredientNotFoundException extends RuntimeException{

    public IngredientNotFoundException(int id){
        super("Ingredient with id : "+id+" not found");
    }

    public IngredientNotFoundException(String message){
        super(message);
    }

}
