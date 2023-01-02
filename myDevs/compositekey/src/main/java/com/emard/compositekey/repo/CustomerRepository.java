package com.emard.compositekey.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.emard.compositekey.entities.Customer;
import com.emard.compositekey.entities.CustomerId;

public interface CustomerRepository extends JpaRepository<Customer, CustomerId> {
    
}
