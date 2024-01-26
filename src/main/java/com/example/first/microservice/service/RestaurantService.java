package com.example.first.microservice.service;

import com.example.first.microservice.dto.RestaurantDto;

import java.util.List;

public interface RestaurantService {

    String createRestaurant(RestaurantDto dto);
    List<RestaurantDto> getAllRestaurant();
    RestaurantDto getRestaurantById(int restaurantId);
    List<RestaurantDto> getRestaurantByName(String name);
    String updateRestaurant(int restaurantId,RestaurantDto restaurantDto);
    String deleteRestaurant(int restaurantId);


}
