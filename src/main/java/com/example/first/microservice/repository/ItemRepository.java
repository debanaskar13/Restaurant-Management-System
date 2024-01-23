package com.example.first.microservice.repository;

import com.example.first.microservice.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item,Integer> {
}
