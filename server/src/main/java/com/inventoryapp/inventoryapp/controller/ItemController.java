package com.inventoryapp.inventoryapp.controller;


import com.inventoryapp.inventoryapp.dao.ItemDao;
import com.inventoryapp.inventoryapp.model.Item;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/")
@CrossOrigin
public class ItemController {

    private final ItemDao itemDao;

    public ItemController(ItemDao itemDao) {
        this.itemDao = itemDao;
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/items")
    public List<Item> getAll() {
        List<Item> allItems = itemDao.findAll();
        return allItems;
    }
}
