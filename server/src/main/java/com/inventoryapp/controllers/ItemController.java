package com.inventoryapp.controllers;



import com.inventoryapp.entities.Item;
import com.inventoryapp.repositories.ItemRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/")
@CrossOrigin
public class ItemController {

//    private final ItemDao itemDao;
    private final ItemRepository itemRepository;
    public ItemController(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/items")
    public List<Item> getAll() {
        List<Item> allItems = itemRepository.findAll();
        return allItems;
    }
}
