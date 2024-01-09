package com.inventoryapp.services;


import com.inventoryapp.entities.Item;
import com.inventoryapp.repositories.ItemRepository;
import jakarta.validation.*;
import org.modelmapper.internal.bytebuddy.implementation.bytecode.Throw;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class ItemService {

    ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    Validator validator = factory.getValidator();

    @Autowired
    private ItemRepository itemRepository;

    public ItemService() {

    }

    public List<Item> listAll() {
        return itemRepository.findAll();
    }

    public Item findById(int id) {
        if (id == 0) throw new IllegalArgumentException("Item id cannot be zero");
        System.out.printf("id is: " + id);
        Item item = itemRepository.getReferenceById(id);

        System.out.println("item from item repo: " + item);
        return item;
    }

    public Item saveItem(@Valid Item item) {
        Set<ConstraintViolation<Item>> violations = validator.validate(item);
        for (ConstraintViolation<Item> violation : violations) {
            throw new IllegalArgumentException((violation.getMessage()));
        }
        System.out.println("item to be posted: " + item);
        Item newItem = new Item();
        try {
            newItem =  itemRepository.save(item);
            System.out.println("newItem: " + newItem);
        } catch (Exception e) {
            throw new IllegalArgumentException("Something wrong with item to be saved.");
        }
        return newItem;
    }

    public void deleteItem(Integer id) {
        if (id == 0) throw new IllegalArgumentException("Item id cannot be zero");
        try {
             itemRepository.deleteById(id);
        } catch (Exception e) {
            System.out.println("Error deleting item: " + e);
        }
    }
}
