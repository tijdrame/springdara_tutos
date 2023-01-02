package com.emard.idgenerators;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.emard.idgenerators.entities.Employee;
import com.emard.idgenerators.repo.EmployeeRepository;


@SpringBootTest
class IdgeneratorsApplicationTests {

	@Autowired
	EmployeeRepository er;

	@Test
	void contextLoads() {
	}

	@Test
	void testCreatedEmployee(){
		Employee e = new Employee();
		e.setName("John Doe");
		er.save(e);
	}

}
