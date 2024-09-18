package com.example.boulderApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.boulderApp.dto.BoulderIn;
import com.example.boulderApp.dto.BoulderOut;
import com.example.boulderApp.errors.BoulderNotFoundException;
import com.example.boulderApp.service.BoulderService;

import lombok.NoArgsConstructor;

@RestController()
@RequestMapping(path = "api/v1/boulders")
@NoArgsConstructor
public class BoulderController {
    @Autowired
    private BoulderService boulderService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BoulderOut createBoulder(@RequestBody BoulderIn boulderIn){
        return boulderService.saveBoulder(boulderIn);
    }
    
    @DeleteMapping("/{boulderId}")
    public ResponseEntity<HttpStatus> deleteBoulder(@PathVariable("boulderId") Long boulderId){
        try {
            boulderService.delete(boulderId);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (BoulderNotFoundException exception) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception exception) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{boulderName}")
    @ResponseStatus(HttpStatus.OK)
    public List<BoulderOut> getBoulderByName(@PathVariable("boulderName") String boulderName){
        return boulderService.getBoulderByName(boulderName);
    }
}
