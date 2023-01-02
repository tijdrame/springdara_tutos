package com.emard.associations;

import java.time.LocalDate;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.emard.associations.manytomany.entities.Programmer;
import com.emard.associations.manytomany.entities.Project;
import com.emard.associations.manytomany.repo.ProgrammerRepository;
import com.emard.associations.onetomany.entities.Customer;
import com.emard.associations.onetomany.entities.PhoneNumber;
import com.emard.associations.onetomany.repo.CustomerRepository;
import com.emard.associations.onetoone.entities.License;
import com.emard.associations.onetoone.entities.Person;
import com.emard.associations.onetoone.repo.LicenseRepository;

@SpringBootTest
class AssociationsApplicationTests {

	@Autowired
	CustomerRepository repository;
	@Autowired ProgrammerRepository programmerRepository;
	@Autowired LicenseRepository licenseRepository;
	@Test
	void contextLoads() {
	}

	@Test
	void testCreateCustomer(){
		Customer c = Customer.builder()
		.name("Tidiane").build();
		c.addPhoneNumber(PhoneNumber.builder()
		.number("1234567890").type("cell").build());
		c.addPhoneNumber(PhoneNumber.builder()
		.number("2222222222").type("home").build());
		repository.save(c);
	}

	@Test
	@Transactional
	void testLoadCustomer(){
		Customer customer = repository.findById(1L).get();
		System.out.println(customer);
	}

	@Test
	@Transactional
	void testUpdateCustomer(){
		Customer customer = repository.findById(1L).get();
		customer.setName("Tidiane Dramé");
		Set<PhoneNumber> numbers = customer.getNumbers();
		numbers.forEach(number-> number.setType("cell"));
		repository.save(customer);
		repository.flush();
		//System.out.println(customer);
	}

	@Test
	void testDeletteCustomer(){
		repository.deleteById(1L);
	}

	@Test
	void testManyToManyCreateProg(){
		Programmer p = Programmer.builder()
		.name("John Doe").salary(2400)
		.projects(Set.of(
			Project.builder().name("Hibernate Project").build(),
			Project.builder().name("Java 19").build()
			))
		.build();
		programmerRepository.save(p);
	}

	@Test
	@Transactional
	void testmtmFindProgrammer(){
		System.out.println(programmerRepository.findById(2L).get());
	}

	@Test
	void testotoCreateLicense(){
		License license = License.builder()
		.type("Car").validFrom(LocalDate.now().minusYears(2))
		.validTo(LocalDate.now().plusYears(3))
		.person(Person.builder().firstName("John")
		.lastName("Doe").age(35).build()).build();
		licenseRepository.save(license);
	}

}
