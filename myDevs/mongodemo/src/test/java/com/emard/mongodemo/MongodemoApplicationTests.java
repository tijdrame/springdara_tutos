package com.emard.mongodemo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.emard.mongodemo.entities.Product;
import com.emard.mongodemo.repo.ProductRepository;

@SpringBootTest
class MongodemoApplicationTests {

	@Autowired ProductRepository repository;
	@Test
	void testSave() {
		Product product = Product.builder()
		.name("Mac Book Pro")
		.price(2000f).build();
		Product saved = repository.save(product);
		assertNotNull(saved);
	}

	@Test
	void testFindAll(){
		assertEquals(1, repository.findAll().size());
	}

	@Test
	void testDelete(){
		repository.deleteById("63b0b9c7291e9c25f4b3ad66");
		assertEquals(0, repository.findAll().size());
	}

}
