package com.emard.componentmapping.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.emard.componentmapping.entities.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    
}
