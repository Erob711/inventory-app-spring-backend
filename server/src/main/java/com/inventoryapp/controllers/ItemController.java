package com.inventoryapp.controllers;



import com.inventoryapp.dtos.ItemDto;
import com.inventoryapp.entities.Item;
import com.inventoryapp.services.ItemService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
//        List<Item> allItems = itemService.listAll();
//        return allItems;
        return itemService.listAll().stream().map(item ->
                modelMapper.map(item, ItemDto.class)).collect(Collectors.toList());
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("items/{id}")
    public Item getById(@PathVariable int id) {
        Item item = itemService.findById(id);
        return item;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/items")
    public Item createItem(@RequestBody Item item) {
        Item newItem = itemService.saveItem(item);
        return newItem;
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/items/{id}")
    public Item updateItem(@PathVariable Integer id) {
        Item itemToUpdate = itemService.findById(id);
        Item updatedItem = itemService.saveItem(itemToUpdate);
        return updatedItem;
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/items/{id}")
    public void deleteItem(@PathVariable Integer id) {
        itemService.deletedItem(id);
    }
}
