package com.example.first.microservice.controller;


import com.example.first.microservice.dto.ItemDto;
import com.example.first.microservice.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/restaurant/{restaurantId}/items")
public class ItemController {

    private final ItemService itemService;


    @PostMapping("")
    public ResponseEntity<?> createItem(@PathVariable("restaurantId") int restaurantId,@RequestBody ItemDto itemDto){
        Map<String,String> response = new HashMap<>();
        response.put("message",this.itemService.createItem(itemDto));
        return ResponseEntity.ok(response);
    }

    @GetMapping("")
    public ResponseEntity<?> getAllItems(@PathVariable("restaurantId") int restaurantId){
        Map<String, List<ItemDto>> response = new HashMap<>();
        response.put("message",this.itemService.getAllItem());
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{itemId}")
    public ResponseEntity<?> getItemById(@PathVariable("restaurantId") int restaurantId,@PathVariable("itemId") int itemId){
        Map<String,ItemDto> response = new HashMap<>();
        response.put("message",this.itemService.getItemById(itemId));
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{itemName}")
    public ResponseEntity<?> getItemByName(@PathVariable("restaurantId") int restaurantId,@PathVariable("itemName") String itemName){
        Map<String,List<ItemDto>> response = new HashMap<>();
        response.put("message",this.itemService.getItemByName(itemName));
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{itemId}")
    public ResponseEntity<?> updateItem(@PathVariable("restaurantId") int restaurantId,@PathVariable("itemId") int itemId,@RequestBody ItemDto itemDto){
        Map<String,String> response = new HashMap<>();
        response.put("message",this.itemService.updateItem(itemId,itemDto));
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{itemId}")
    public ResponseEntity<?> deleteItem(@PathVariable("restaurantId") int restaurantId,@PathVariable("itemId") int itemId){
        Map<String,String> response = new HashMap<>();
        response.put("message",this.itemService.deleteItem(itemId));
        return ResponseEntity.ok(response);
    }


}
