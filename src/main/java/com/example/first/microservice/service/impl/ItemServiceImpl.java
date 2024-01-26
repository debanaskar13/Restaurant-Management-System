package com.example.first.microservice.service.impl;

import com.example.first.microservice.dto.ItemDto;
import com.example.first.microservice.exception.ItemNotFoundException;
import com.example.first.microservice.exception.UserNotFoundException;
import com.example.first.microservice.model.Item;
import com.example.first.microservice.model.User;
import com.example.first.microservice.repository.ItemRepository;
import com.example.first.microservice.repository.UserRepository;
import com.example.first.microservice.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService {

    private final ModelMapper modelMapper;
    private final ItemRepository itemRepo;
    private final UserRepository userRepo;

    @Override
    public String createItem(ItemDto dto) {
        User user = this.userRepo.findById(dto.getUserId()).orElseThrow(() -> new UserNotFoundException(dto.getUserId()));
        User vendor = dto.getVendorId() != 0 ? this.userRepo.findById(dto.getVendorId()).orElseThrow(() -> new UserNotFoundException("Vendor not found")) : null;
        Item item = itemDtoToItem(dto);
        item.setUser(user);
        item.setVendor(vendor);
        this.itemRepo.save(item);
        return "Item Saved Successfully";
    }

    @Override
    public List<ItemDto> getAllItem() {
        return this.itemRepo.findAll().stream().map(this::itemToItemDto).collect(Collectors.toList());
    }

    @Override
    public ItemDto getItemById(int itemId) {
        return this.itemRepo.findById(itemId).map(this::itemToItemDto).orElseThrow(() -> new ItemNotFoundException(itemId));
    }

    @Override
    public List<ItemDto> getItemByName(String itemName) {
        return this.itemRepo
                .findByTitle(itemName)
                .stream()
                .map(this::itemToItemDto)
                .toList();

    }

    @Override
    public String updateItem(int itemId, ItemDto dto) {
        return null;
    }

    @Override
    public String deleteItem(int itemId) {
        this.itemRepo.deleteById(itemId);
        return "Item Deleted Successfully";
    }

    private Item itemDtoToItem(ItemDto dto){
        return this.modelMapper.map(dto,Item.class);
    }

    private ItemDto itemToItemDto(Item item){
        ItemDto dto = this.modelMapper.map(item, ItemDto.class);
        dto.setUserId(item.getUser().getId());
        dto.setVendorId(item.getVendor().getId());
        return dto;
    }
}
