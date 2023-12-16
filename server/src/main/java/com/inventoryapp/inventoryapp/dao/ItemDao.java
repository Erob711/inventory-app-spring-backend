package com.inventoryapp.inventoryapp.dao;

import com.inventoryapp.inventoryapp.model.Item;

import java.util.List;

public interface ItemDao {

    List<Item> findAll();
}
