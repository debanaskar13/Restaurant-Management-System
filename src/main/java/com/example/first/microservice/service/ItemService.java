package com.example.first.microservice.service;

import com.example.first.microservice.dto.ItemDto;

import java.util.List;

public interface ItemService {

    String createItem(ItemDto dto);
    List<ItemDto> getAllItem();
    ItemDto getItemById(int itemId);

    List<ItemDto> getItemByName(String itemName);
    String updateItem(int itemId,ItemDto dto);
    String deleteItem(int id);

}
