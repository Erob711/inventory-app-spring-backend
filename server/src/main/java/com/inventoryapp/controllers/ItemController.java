package com.inventoryapp.controllers;



import com.inventoryapp.dtos.ItemDto;
import com.inventoryapp.entities.Item;
import com.inventoryapp.services.ItemService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path="/")
@CrossOrigin
public class ItemController {

//    private final ItemDao itemDao;
    @Autowired
    private ModelMapper modelMapper;
    private final ItemService itemService;
    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/items")
    public List<ItemDto> getAll() {
        return itemService.listAll().stream().map(item ->
                modelMapper.map(item, ItemDto.class)).collect(Collectors.toList());
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("items/{id}")
    public ResponseEntity<ItemDto> getById(@PathVariable int id) {
        Item item = itemService.findById(id);
        ItemDto itemResponse = modelMapper.map(item, ItemDto.class);
        return ResponseEntity.ok().body(itemResponse);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/items")
    public ResponseEntity<ItemDto> createItem(@RequestBody ItemDto itemDto) {
        Item itemRequest = modelMapper.map(itemDto, Item.class);
        Item item = itemService.saveItem(itemRequest);
        ItemDto itemResponse = modelMapper.map(item, ItemDto.class);

        return new ResponseEntity<ItemDto>(itemResponse, HttpStatus.CREATED);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/items/{id}")
    public ResponseEntity<ItemDto> updateItem(@PathVariable Integer id, @RequestBody ItemDto itemDto) {

        Item itemRequest = modelMapper.map(itemDto, Item.class);
        Item item = itemService.saveItem(itemRequest);

        ItemDto itemResponse = modelMapper.map(item, ItemDto.class);

        return ResponseEntity.ok().body(itemResponse);
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/items/{id}")
    public void deleteItem(@PathVariable Integer id) {
        itemService.deleteItem(id);
    }
}
