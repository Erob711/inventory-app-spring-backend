package com.inventoryapp.controllers;

import com.inventoryapp.dtos.ItemDto;
import com.inventoryapp.dtos.UserDto;
import com.inventoryapp.entities.Item;
import com.inventoryapp.entities.User;
import com.inventoryapp.repositories.UserRepository;
import com.inventoryapp.services.ItemService;
import com.inventoryapp.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path="/")
@CrossOrigin
public class UserController {

    @Autowired
    private ModelMapper modelMapper;

    private final UserService userService;
    private final ItemService itemService;
    private final UserRepository userRepository;

    public UserController(UserService userService, ItemService itemService,
                          UserRepository userRepository) {
        this.userService = userService;
        this.itemService = itemService;
        this.userRepository = userRepository;
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/users")
    public List<UserDto> getAll() {
        return userService.listAll().stream().map(user ->
                modelMapper.map(user, UserDto.class)).collect(Collectors.toList());
    }

    //not good convention. setting up this way to interact with the client.
    // should instead have schema set to retriece by Integer id. not id as a String to match "username". client expects to be able to get user by username.
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/users/{username}")
    public ResponseEntity<UserDto> getOne(@PathVariable String username) {
        ResponseEntity<UserDto> userDto = null;
        List<UserDto> users =  userService.listAll().stream().map(user ->
                modelMapper.map(user, UserDto.class)).collect(Collectors.toList());

        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getUsername().equals(username)) {
                userDto = ResponseEntity.ok().body(users.get(i));
                return userDto;
            }
        }
        return userDto;
    }


    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/users/getById/{id}")
    public ResponseEntity<UserDto> getById(@PathVariable Integer id) {
        User user = userService.findById(id);
        UserDto userResponse = modelMapper.map(user, UserDto.class);
        return ResponseEntity.ok().body(userResponse);
    }


    //should refactor. Not sure of best practices for this type of action. also should return something helpful when method called
    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/users/editCart/{removeOrAdd}/{userId}/{itemId}")
    public void addItemToUser(@PathVariable String removeOrAdd, @PathVariable Integer userId, @PathVariable Integer itemId) {
        User user = userService.findById(userId);
        Item item = itemService.findById(itemId);
        List<Item> userItems = user.getUsersItems();

        try {
            if (removeOrAdd.equals("add")) {
                userItems.add(item);
                userRepository.save(user);

            } else {
                userItems.remove(item);
                userRepository.save(user);
            }
        } catch (Exception e) {
            System.out.print("Oops, something went wrong: " + e);
        }
    }



}
