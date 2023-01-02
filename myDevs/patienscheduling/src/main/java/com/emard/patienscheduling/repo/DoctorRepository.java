package com.emard.patienscheduling.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.emard.patienscheduling.entities.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
    
}
