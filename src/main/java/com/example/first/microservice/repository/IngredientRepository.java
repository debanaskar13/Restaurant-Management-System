package com.example.first.microservice.repository;

import com.example.first.microservice.model.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngredientRepository extends JpaRepository<Ingredient,Integer> {
}
