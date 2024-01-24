package com.example.first.microservice.service.impl;

import com.example.first.microservice.dto.ItemDto;
import com.example.first.microservice.model.Item;
import com.example.first.microservice.repository.ItemRepository;
import com.example.first.microservice.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService {

    private final ModelMapper modelMapper;
    private ItemRepository itemRepo;

    @Override
    public String createItem(ItemDto dto) {
        return null;
    }

    @Override
    public List<ItemDto> getAllItem() {
        return null;
    }

    @Override
    public ItemDto getItemById(int itemId) {
        return null;
    }

    @Override
    public String UpdateItem(int itemId, ItemDto dto) {
        return null;
    }

    @Override
    public void deleteItem(int id) {

    }

    private Item itemDtoToItem(ItemDto dto){
        return this.modelMapper.map(dto,Item.class);
    }

    private ItemDto itemToItemDto(Item item){
        return this.modelMapper.map(item, ItemDto.class);
    }
}
