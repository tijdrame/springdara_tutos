package com.emard.associations.onetoone.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.emard.associations.onetoone.entities.License;

public interface LicenseRepository extends JpaRepository<License, Long> {
    
}
