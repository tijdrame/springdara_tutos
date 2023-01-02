package com.emard.compositekey;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.emard.compositekey.entities.Customer;
import com.emard.compositekey.entities.CustomerId;
import com.emard.compositekey.repo.CustomerRepository;

@SpringBootTest
class CompositekeyApplicationTests {

	@Autowired CustomerRepository repository;
	@Test
	void saveCustomer() {
		Customer customer = Customer.builder()
		.id(CustomerId.builder().id(2)
		.name("test 2").build())
		.email("kjhcd@jh.fr").build();
		repository.save(customer);
	}

}
