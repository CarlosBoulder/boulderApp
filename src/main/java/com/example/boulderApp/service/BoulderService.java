package com.example.boulderApp.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.boulderApp.dto.BoulderIn;
import com.example.boulderApp.dto.BoulderOut;
import com.example.boulderApp.entity.Boulder;
import com.example.boulderApp.errors.BoulderNotFoundException;
import com.example.boulderApp.repository.BoulderRepository;

@Service
public class BoulderService {
    @Autowired
    BoulderRepository boulderRepository;

    public BoulderOut saveBoulder(BoulderIn boulderIn){
        Boulder boulder = boulderRepository.save(new Boulder(boulderIn.getBoulderName(), boulderIn.getGrade(), boulderIn.getCrag()));

        return new BoulderOut(boulder.getId(),boulder.getBoulderName(), boulder.getGrade(), boulder.getCrag());
    }

    public void delete(Long id){
        Optional<Boulder> boulder = boulderRepository.findById(id);
        if (boulder.isEmpty()) {
            throw new BoulderNotFoundException();
        }

        boulderRepository.deleteById(id);
    }
}
