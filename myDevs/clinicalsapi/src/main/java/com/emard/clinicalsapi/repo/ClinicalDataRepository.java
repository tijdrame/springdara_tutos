package com.emard.clinicalsapi.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.emard.clinicalsapi.entities.ClinicalData;

public interface ClinicalDataRepository extends JpaRepository<ClinicalData, Long> {
    
}
