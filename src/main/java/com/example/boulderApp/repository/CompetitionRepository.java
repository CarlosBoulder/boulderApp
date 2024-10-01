package com.example.boulderApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.boulderApp.entity.Competition;

public interface CompetitionRepository extends JpaRepository<Competition, Long> {

}
