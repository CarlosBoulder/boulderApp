package com.example.boulderApp.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class CompetitionIn {
    public String competitionName;
    public LocalDateTime startDate;
    public LocalDateTime finishDate;
}
