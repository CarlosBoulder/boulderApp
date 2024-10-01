package com.example.boulderApp.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@Table(name = "boulders")
public class Boulder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "boulderName", nullable = false, length = 200)
    private String boulderName;

    @Column(name = "grade", nullable = false, length = 10)
    private String grade;

    @Column(name = "crag", nullable = false, length = 100)
    private String crag;

    public Boulder(String boulderName, String grade, String crag) {
        this.boulderName = boulderName;
        this.grade = grade;
        this.crag = crag;
    }
}
