package com.inventoryapp.controllers;

import com.inventoryapp.dtos.UserDto;
import com.inventoryapp.entities.User;
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

    public UserController(UserService userService) {
        this.userService = userService;
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


//    @ResponseStatus(HttpStatus.OK)
//    @GetMapping("/users/cart/{id}")



}
