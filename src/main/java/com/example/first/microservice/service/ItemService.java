package com.example.first.microservice.service;

import com.example.first.microservice.dto.ItemDto;

import java.util.List;

public interface ItemService {

    String createItem(ItemDto dto);
    List<ItemDto> getAllItem();
    ItemDto getItemById(int itemId);
    String UpdateItem(int itemId,ItemDto dto);
    String deleteItem(int id);

}
