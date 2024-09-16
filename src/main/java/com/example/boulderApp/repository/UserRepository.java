package com.example.boulderApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.boulderApp.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{
    
}
