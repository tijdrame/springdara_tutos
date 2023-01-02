package com.emard.patienscheduling.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.emard.patienscheduling.entities.Patient;

public interface PatientRepository extends JpaRepository<Patient, Long> {
    
}
