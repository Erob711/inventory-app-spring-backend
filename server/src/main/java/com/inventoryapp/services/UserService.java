package com.inventoryapp.services;


import com.inventoryapp.entities.Item;
import com.inventoryapp.entities.User;
import com.inventoryapp.repositories.UserRepository;
import jakarta.validation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class UserService {

    ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    Validator validator = factory.getValidator();
    @Autowired
    private UserRepository userRepository;

    public List<User> listAll() {
        return userRepository.findAll();
    }

    public User findById(int id) {
        if (id == 0) throw new IllegalArgumentException("User id cannot be zero");
        System.out.printf("id is: " + id);
        User user = userRepository.getReferenceById(id);
//        Item itemFound = itemRepository.findById(id);
        return user;
    }


    public User saveUser(@Valid User user) {

        Set<ConstraintViolation<User>> violations = validator.validate(user);
        for (ConstraintViolation<User> violation : violations) {
            throw new IllegalArgumentException((violation.getMessage()));
        }

        User newUser = new User();
        try {
            newUser =  userRepository.save(user);
        } catch (Exception e) {
            System.out.println("Error updating user: " + e);
        }
        return newUser;
    }

    public void deleteUser(Integer id) {
        try {
            userRepository.deleteById(id);
        } catch (Exception e) {
            System.out.println("Error deleting item: " + e);
        }
    }
}
