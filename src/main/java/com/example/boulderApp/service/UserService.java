package com.example.boulderApp.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.boulderApp.dto.UserInDto;
import com.example.boulderApp.dto.UserOutDto;
import com.example.boulderApp.entity.User;
import com.example.boulderApp.errors.UserNotFoundException;
import com.example.boulderApp.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public UserOutDto saveUser(UserInDto userInDto){
        User user = userRepository.save(new User(userInDto.getUsername(), userInDto.getEmail()));

        return new UserOutDto(user.getUsername(), user.getEmail());
    }

    public void delete(Long id){
        Optional<User> user = userRepository.findById(id);
        if (user.isEmpty()) {
            throw new UserNotFoundException();
        }

        userRepository.deleteById(id);
    }
}
