package com.emard.jpqlandnativesql;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.emard.jpqlandnativesql.entities.Student;
import com.emard.jpqlandnativesql.repo.StudentRepository;

@SpringBootTest
class JpqlandnativesqlApplicationTests {

	@Autowired
	StudentRepository repository;

	@Test
	void testStudentCreate() {
		Student tij = Student.builder()
		.firstName("Tidiane")
		.lastName("Dramé")
		.score(98).build();
		Student bill = Student.builder()
		.firstName("Bill")
		.lastName("Gates")
		.score(88).build();
		repository.saveAll(List.of(tij, bill));

	}

	@Test
	void testFindAll(){
		repository.findAllStudent(PageRequest.of(1, 5, Direction.ASC, "id")).forEach(System.out::println);
	}

	@Test
	void testFindAllStudentPartial(){
		List<Object[]> data = repository.findAllStudentPartialData();
		for (Object[] objects : data) {
			System.out.println(objects[0]);
			System.out.println(objects[1]);
		}
	}

	@Test
	void testFindStudentByFirstname(){
		repository.findStudentByFirstName("Tdiane").forEach(System.out::println);
	}

	@Test
	void testFindStudentByScore(){
		repository.findStudentForGivenScore(80, 90).forEach(System.out::println);
	}

	@Test
	@Transactional
	@Rollback(false)//junit fait un rollback par def, pour eviter ça
	void testDeleteStudentByFirstName(){
		repository.deleteStudentByFisrtName("Tdiane");
	}

	@Test
	void testFindAllNQ(){
		repository.findAllStudentNQ().forEach(System.out::println);
	}

	@Test
	void testFindByFirstNameNQ(){
		repository.findStudentByFirstNameNQ("Tidiane").forEach(System.out::println);
	}

	@Test
	void testFindAllStudentPartialNQ(){
		List<Object[]> data = repository.findAllStudentPartialDataNQ();
		for (Object[] objects : data) {
			System.out.println(objects[0]+ " - "+objects[1]);
		}
	}

}
