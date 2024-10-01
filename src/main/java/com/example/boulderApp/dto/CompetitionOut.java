package com.example.boulderApp.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class CompetitionOut {
    public Long id;
    public String competitionName;
    public LocalDateTime startDate;
    public LocalDateTime finishDate;

    public CompetitionOut(Long id, String competitionName, LocalDateTime startDate, LocalDateTime finishDate) {
        this.id = id;
        this.competitionName = competitionName;
        this.startDate = startDate;
        this.finishDate = finishDate;
    }
}
