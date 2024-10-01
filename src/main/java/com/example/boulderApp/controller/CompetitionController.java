package com.example.boulderApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.boulderApp.dto.CompetitionIn;
import com.example.boulderApp.dto.CompetitionOut;
import com.example.boulderApp.service.CompetitionService;

import lombok.NoArgsConstructor;

@RestController()
@RequestMapping(path = "api/v1/competitions")
@NoArgsConstructor
public class CompetitionController {
    @Autowired
    private CompetitionService competitionService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CompetitionOut createCompetition(@RequestBody CompetitionIn competitionIn) {
        return competitionService.saveCompetitions(competitionIn);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CompetitionOut findCompetitionById(@PathVariable(name = "id") Long id) {
        return competitionService.findCompetitionById(id);
    }

}
