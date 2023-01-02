package com.emard.jpqlandnativesql.repo;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.emard.jpqlandnativesql.entities.Student;

public interface StudentRepository extends JpaRepository<Student, Long>{
    
    @Query("from Student")
    List<Student> findAllStudent(Pageable pageable);

    @Query("Select s.firstName, s.lastName from Student s")
    List<Object[]> findAllStudentPartialData();

    @Query("from Student s where s.firstName =:firstName")
    List<Student> findStudentByFirstName(@Param("firstName") String firstName);

    @Query("from Student where score >:min and score <:max")
    List<Student> findStudentForGivenScore(@Param("min")Integer min, @Param("max")Integer max);

    @Modifying
    @Query("Delete from Student where firstName =:firstName")
    void deleteStudentByFisrtName(@Param("firstName") String firstName);

    @Query(value = "SELECT * FROM student", nativeQuery = true)
    List<Student> findAllStudentNQ();

    @Query(value = "SELECT * FROM student WHERE fname =:firstName", nativeQuery = true)
    List<Student> findStudentByFirstNameNQ(@Param("firstName") String firstName);

    @Query(value = "Select s.fname, s.lname from Student s", nativeQuery = true)
    List<Object[]> findAllStudentPartialDataNQ();
}
