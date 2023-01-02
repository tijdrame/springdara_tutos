package com.emard.idgenerators.repo;

import org.springframework.data.repository.CrudRepository;

import com.emard.idgenerators.entities.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {
    
}
