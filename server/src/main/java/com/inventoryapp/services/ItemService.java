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

    public Optional <Item> findById(Integer id) {
        System.out.printf("id is: " + id);
        Optional <Item> item = itemRepository.findById(id);
        System.out.println("item from item repo: " + item);
        return item;
    }

    public Item saveItem(Item item) {
        System.out.println("item to be posted: " + item);
        Item newItem = new Item();
        try {
            newItem =  itemRepository.saveAndFlush(item);
            System.out.println("newItem: " + newItem);
        } catch (Exception e) {
            System.out.println("Error updating item: " + e);
        }
        return newItem;
    }

    public void deletedItem(Integer id) {
        try {
             itemRepository.deleteById(id);
        } catch (Exception e) {
            System.out.println("Error deleting item: " + e);
        }
    }
}
