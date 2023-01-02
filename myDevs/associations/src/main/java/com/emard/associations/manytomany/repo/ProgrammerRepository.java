package com.emard.associations.manytomany.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.emard.associations.manytomany.entities.Programmer;

public interface ProgrammerRepository extends JpaRepository<Programmer, Long> {
    
}
