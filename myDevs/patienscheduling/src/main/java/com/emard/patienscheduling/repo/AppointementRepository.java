package com.emard.patienscheduling.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.emard.patienscheduling.entities.Appointment;

public interface AppointementRepository extends JpaRepository<Appointment, Long> {
    
}
