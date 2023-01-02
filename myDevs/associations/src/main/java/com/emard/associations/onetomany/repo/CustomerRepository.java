package com.emard.associations.onetomany.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.emard.associations.onetomany.entities.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    
}
