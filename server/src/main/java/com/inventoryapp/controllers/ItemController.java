package com.inventoryapp.controllers;



import com.inventoryapp.entities.Item;
import com.inventoryapp.repositories.ItemRepository;
import com.inventoryapp.services.ItemService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path="/")
@CrossOrigin
public class ItemController {

//    private final ItemDao itemDao;
    private final ItemService itemService;
    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/items")
    public List<Item> getAll() {
        List<Item> allItems = itemService.listAll();
        return allItems;
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("items/{id}")
    public Optional<Item> getById(@PathVariable Integer id) {
        Optional<Item> item = itemService.findById(id);
        return item;
    }
}
