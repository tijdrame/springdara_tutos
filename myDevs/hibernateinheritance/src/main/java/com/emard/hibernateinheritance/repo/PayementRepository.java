package com.emard.hibernateinheritance.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.emard.hibernateinheritance.entites.Payment;

public interface PayementRepository extends JpaRepository<Payment, Integer>{
    
}
