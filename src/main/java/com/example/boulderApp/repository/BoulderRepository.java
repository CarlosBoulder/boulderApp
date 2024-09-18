package com.example.boulderApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.boulderApp.entity.Boulder;

public interface BoulderRepository extends JpaRepository<Boulder, Long>{
    
}
