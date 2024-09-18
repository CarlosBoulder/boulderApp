package com.example.boulderApp.dto;

import lombok.Data;

@Data
public class BoulderOut {
    public Long id;
    public String boulderName;
    public String grade;
    public String crag;

    public BoulderOut(Long id, String boulderName, String grade, String crag){
        this.id = id;
        this.boulderName = boulderName;
        this.grade = grade;
        this.crag = crag;
    }
}
