package com.example.boulderApp.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "competitions")
public class Competition {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "competitionName", nullable = false, length = 100)
    private String competitionName;

    @Column(name = "startDate", nullable = false, length = 15)
    private LocalDateTime startDate;

    @Column(name = "finishDate", nullable = false, length = 15)
    private LocalDateTime finishDate;

    public Competition(String competitionName, LocalDateTime startDate, LocalDateTime finishDate) {
        this.competitionName = competitionName;
        this.startDate = startDate;
        this.finishDate = finishDate;
    }
}
