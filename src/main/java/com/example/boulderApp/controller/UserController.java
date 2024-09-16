package com.example.boulderApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.boulderApp.dto.UserInDto;
import com.example.boulderApp.dto.UserOutDto;
import com.example.boulderApp.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController()
@RequestMapping(path = "api/v1/users")
@RequiredArgsConstructor
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserOutDto createUser(@RequestBody UserInDto userInDto){
        UserOutDto userOutDto = userService.saveUser(userInDto);

        return userOutDto;
    }
}
