package com.example.boulderApp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.boulderApp.dto.BoulderIn;
import com.example.boulderApp.dto.BoulderOut;
import com.example.boulderApp.entity.Boulder;
import com.example.boulderApp.errors.BoulderNotFoundException;
import com.example.boulderApp.projections.BoulderProjection;
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

       public List<BoulderOut> getBoulderByName(String boulderString) {
        List<BoulderOut> result = new ArrayList<>();
        List<BoulderProjection> data = boulderRepository.findByBoulderName(boulderString);

        for (BoulderProjection boulderProjection : data) {
            Long id = boulderProjection.getId();
            String boulderName = boulderProjection.getBoulder_name();
            String grade = boulderProjection.getGrade();
            String crag = boulderProjection.getCrag();

            BoulderOut boulderOut = new BoulderOut(id, boulderName, grade, crag);
            result.add(boulderOut);
        }

        return result;
    }
}
