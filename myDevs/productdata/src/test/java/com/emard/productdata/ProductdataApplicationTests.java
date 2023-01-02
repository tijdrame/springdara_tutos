package com.emard.productdata;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.emard.productdata.entities.Customer;
import com.emard.productdata.entities.Product;
import com.emard.productdata.repo.CustomerRepository;
import com.emard.productdata.repo.ProductRepository;

import jakarta.persistence.EntityManager;

@SpringBootTest
class ProductdataApplicationTests {

	@Autowired
	ProductRepository repository;
	@Autowired
	CustomerRepository customerRepository;

	@Autowired EntityManager entityManager;
	@Test
	void contextLoads() {
	}

	@Test
	void testCreate(){
		Product p = new Product();
		p.setId(1);
		p.setName("IPhone 9");
		p.setDesc("Awzsome!!");
		p.setPrice(1000d);
		repository.save(p);
	}

	@Test
	void testRead(){
		Product p = repository.findById(2).get();
		assertNotNull(p);
		assertEquals("IPhone 9", p.getName());
	}

	@Test
	void testUpdate(){
		Product p = repository.findById(2).get();
		p.setPrice(750d);
		p.setPrice(540d);
		repository.save(p);
	}

	@Test
	void testDelete(){
		if(repository.existsById(1)){
			repository.deleteById(1);
		}
		
	}

	@Test
	void testCount(){
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>"+repository.count());
		
	}

	@Test
	void testCreateCustomer(){
		Customer c = new Customer();
		c.setId(1);
		c.setName("John");
		c.setEmail("customer1@gmail.com");
		customerRepository.save(c);
	}

	@Test
	void testReadCustomer(){
		Customer c = customerRepository.findById(1).get();
		assertNotNull(c);
		assertEquals("John", c.getName());
	}

	@Test
	void testUpdateCustomer(){
		Customer c = customerRepository.findById(1).get();
		c.setName("John Doe");
		customerRepository.save(c);
	}

	@Test
	void testDeleteCustomer(){
		if(customerRepository.existsById(1)){
			customerRepository.deleteById(1);
		}
	}

	@Test
	void testFindByName(){
		List<Product> products = repository.findByName("IWatch");
		products.forEach(System.out::println);
	}

	@Test
	void testFindByNameAndDesc(){
		List<Product> products = repository.findByNameAndDesc("TV", "From Samsung Inc");
		products.forEach(System.out::println);
	}
	
	@Test
	void testFindByPriceGreaterThan(){
		List<Product> products = repository.findByPriceGreaterThan(1000d);
		products.forEach(System.out::println);
	}

	@Test
	void testFindByDescContains(){
		List<Product> products = repository.findByDescContains("Apple");
		products.forEach(System.out::println);
	}

	@Test
	void testFindByPriceBetween(){
		List<Product> products = repository.findByPriceBetween(500d, 2500d);
		products.forEach(System.out::println);
	}

	@Test
	void testFindByDescLike(){
		List<Product> products = repository.findByDescLike("%LG%");
		products.forEach(System.out::println);
	}

	@Test
	void testFindByIdsIn(){
		//Arrays.asList(1,2,4)
		Pageable pageable = PageRequest.of(1, 2);
		List<Product> products = repository.findByIdIn(List.of(1,2,4), pageable);
		products.forEach(System.out::println);
	}

	@Test
	void testFindAllPaging(){
		Pageable pageable = PageRequest.of(1, 2);
		Page<Product> products = repository.findAll(pageable);
		products.forEach(System.out::println);
	}

	@Test
	void testFindAllSorting(){
		//Iterable<Product> products = repository.findAll(Sort.by("name"));
		//Iterable<Product> products = repository.findAll(Sort.by(Direction.DESC,"name", "price"));
		Iterable<Product> products = repository.findAll(Sort.by(new Sort.Order(Direction.DESC, "name"),
		new Sort.Order(null, "price")));
		products.forEach(System.out::println);
	}

	@Test
	void testFindAllPagingAndSorting(){
		Pageable pageable = PageRequest.of(0, 2, Direction.DESC, "name");
		repository.findAll(pageable).forEach(System.out::println);
	}

	@Test
	@Transactional
	@Rollback(false)
	void testUpdateCustomerByEmail(){
		customerRepository.upadateCustomerByEmail("customer_14@gmail.com", 1);
	}

	@Test
	@Transactional
	void testCaching(){
		Session session = entityManager.unwrap(Session.class);
		Product product = repository.findById(1).get();
		repository.findById(1);
		session.evict(product);
		repository.findById(1);
	}

	@Test
	void testFindAllProducts(){
		repository.findAllProducts().forEach(System.out::println);
	}

	@Test
	void testFindAllProductsByPrice(){
		repository.findAllProductsByPrice(1000d).forEach(System.out::println);
	}

	@Test
	void testFindAllProductsCountByPrice(){
		System.out.println("Count= "+ repository.findAllProductsCountByPrice(1000d));
	}

}
