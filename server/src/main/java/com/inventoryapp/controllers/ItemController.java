package com.inventoryapp.controllers;



import com.inventoryapp.entities.Item;
import com.inventoryapp.repositories.ItemRepository;
import com.inventoryapp.services.ItemService;
import jakarta.annotation.security.PermitAll;
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
        Optional <Item> item = itemService.findById(id);
        return item;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/items")
    public Item createItem(@RequestBody Item item) {
        Item newItem = itemService.saveItem(item);
        return newItem;
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/items")
    public Item updateItem(@RequestBody Item item) {
        Item updatedItem = itemService.saveItem(item);
        return updatedItem;
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/items/{id}")
    public void deleteItem(@PathVariable Integer id) {
        itemService.deletedItem(id);
    }
}
