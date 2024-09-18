package com.example.boulderApp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.boulderApp.entity.Boulder;
import com.example.boulderApp.projections.BoulderProjection;

public interface BoulderRepository extends JpaRepository<Boulder, Long>{
    @Query(value = "SELECT boulder_name, grade, crag, id FROM boulders WHERE boulder_name LIKE CONCAT('%', :boulderName, '%');", nativeQuery = true)
    List<BoulderProjection> findByBoulderName(@Param("boulderName") String boulderName);

}
