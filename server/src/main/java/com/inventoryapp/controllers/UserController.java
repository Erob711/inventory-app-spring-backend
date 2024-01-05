package com.inventoryapp.controllers;


import com.inventoryapp.dtos.ItemDto;
import com.inventoryapp.dtos.UserDto;
import com.inventoryapp.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.http.HttpStatus;
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


}
