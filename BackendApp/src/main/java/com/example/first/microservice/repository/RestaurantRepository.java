package com.example.first.microservice.repository;

import com.example.first.microservice.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant,Integer> {

    List<Restaurant> findByName(String name);
}
