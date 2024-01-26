package com.example.first.microservice.service.impl;

import com.example.first.microservice.dto.RestaurantDto;
import com.example.first.microservice.exception.RestaurantNotFoundException;
import com.example.first.microservice.exception.UserNotFoundException;
import com.example.first.microservice.model.Restaurant;
import com.example.first.microservice.model.User;
import com.example.first.microservice.repository.RestaurantRepository;
import com.example.first.microservice.repository.UserRepository;
import com.example.first.microservice.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RestaurantServiceImpl implements RestaurantService {

    private final RestaurantRepository restaurantRepo;
    private final UserRepository userRepo;
    private final ModelMapper modelMapper;

    @Override
    public String createRestaurant(RestaurantDto dto) {
        User user = this.userRepo.findById(dto.getManager().getId()).orElseThrow(() -> new UserNotFoundException(dto.getManager().getId()));
        Restaurant restaurant = this.restaurantDtoToRestaurant(dto);
        restaurant.setManager(user);
        this.restaurantRepo.save(restaurant);
        return "Restaurant has been saved successfully";
    }

    @Override
    public List<RestaurantDto> getAllRestaurant() {
        return this.restaurantRepo.findAll().stream().map(this::restaurantToRestaurantDto).toList();
    }

    @Override
    public RestaurantDto getRestaurantById(int restaurantId) {
        return this.restaurantRepo.findById(restaurantId).map(this::restaurantToRestaurantDto).orElseThrow(() -> new RestaurantNotFoundException(restaurantId));
    }

    @Override
    public List<RestaurantDto> getRestaurantByName(String name) {
        return this.restaurantRepo.findByName(name).stream().map(this::restaurantToRestaurantDto).toList();
    }

    @Override
    public String updateRestaurant(int restaurantId, RestaurantDto restaurantDto) {
        return null;
    }

    @Override
    public String deleteRestaurant(int restaurantId) {
        this.restaurantRepo.deleteById(restaurantId);
        return "Restaurant Deleted Successfully";
    }


    private RestaurantDto restaurantToRestaurantDto(Restaurant restaurant){
        return this.modelMapper.map(restaurant,RestaurantDto.class);
    }
    private Restaurant restaurantDtoToRestaurant(RestaurantDto dto){
        return this.modelMapper.map(dto,Restaurant.class);
    }
}
