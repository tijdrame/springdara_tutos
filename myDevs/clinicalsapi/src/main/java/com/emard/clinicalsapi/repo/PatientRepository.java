package com.emard.clinicalsapi.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.emard.clinicalsapi.entities.Patient;

public interface PatientRepository extends JpaRepository<Patient, Long> {
    
}
