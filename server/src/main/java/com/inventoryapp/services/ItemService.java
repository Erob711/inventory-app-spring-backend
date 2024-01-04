package com.inventoryapp.services;


import com.inventoryapp.entities.Item;
import com.inventoryapp.repositories.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;

    public List<Item> listAll() {
        return itemRepository.findAll();
    }

    public Optional<Item> findById(Integer id) {
        Optional<Item> item = itemRepository.findById(id);
        return item;
    }
}
