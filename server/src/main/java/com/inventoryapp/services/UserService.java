package com.inventoryapp.services;


import com.inventoryapp.entities.Item;
import com.inventoryapp.entities.User;
import com.inventoryapp.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> listAll() {
        return userRepository.findAll();
    }

    public User findById(int id) {
        System.out.printf("id is: " + id);
        User user = userRepository.getReferenceById(id);
//        Item itemFound = itemRepository.findById(id);
        return user;
    }
}
