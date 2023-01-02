package com.emard.componentmapping;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.emard.componentmapping.entities.Address;
import com.emard.componentmapping.entities.Employee;
import com.emard.componentmapping.repo.EmployeeRepository;

@SpringBootTest
class ComponentmappingApplicationTests {

	@Autowired
	EmployeeRepository repository;
	@Test
	void contextLoads() {
	}

	@Test
	void testCreate(){
		Employee emp = Employee.builder().id(123)
		.name("Tidiane").address(Address.builder()
		.city("Dakar").country("Africa")
		.state("Sénégal").zipcode("12345")
		.streetaddress("street 14").build())
		.build();
		repository.save(emp);
	}

}
