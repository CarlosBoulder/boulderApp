package com.example.boulderApp.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.boulderApp.dto.CompetitionIn;
import com.example.boulderApp.dto.CompetitionOut;
import com.example.boulderApp.entity.Competition;
import com.example.boulderApp.errors.CompetitionNotFoundException;
import com.example.boulderApp.repository.CompetitionRepository;

@Service
public class CompetitionService {
    @Autowired
    CompetitionRepository competitionRepository;

    public CompetitionOut saveCompetitions(CompetitionIn competitionIn) {
        Competition competition = competitionRepository.save(new Competition(competitionIn.getCompetitionName(),
                competitionIn.getStartDate(), competitionIn.getFinishDate()));

        return new CompetitionOut(competition.getId(), competition.getCompetitionName(), competition.getStartDate(),
                competition.getFinishDate());
    }

    public CompetitionOut findCompetitionById(Long id) {
        Optional<Competition> competition = competitionRepository.findById(id);

        if (competition.isEmpty()) {
            throw new CompetitionNotFoundException();
        }

        return new CompetitionOut(competition.get().getId(), competition.get().getCompetitionName(),
                competition.get().getStartDate(), competition.get().getFinishDate());
    }

}
