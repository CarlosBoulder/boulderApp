package com.example.boulderApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.boulderApp.dto.UserInDto;
import com.example.boulderApp.dto.UserOutDto;
import com.example.boulderApp.entity.User;
import com.example.boulderApp.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public UserOutDto saveUser(UserInDto userInDto){
        User user = userRepository.save(new User(userInDto.getUsername(), userInDto.getEmail()));

        UserOutDto userOutDto = new UserOutDto(user.getUsername(), user.getEmail());

        return userOutDto;
    }
}
