package com.emard.productdata.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.emard.productdata.entities.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Integer>{
    List<Customer> findByEmailAndName(String email, String name);
    List<Customer> findByEmailLike(String email);
    List<Customer> findByIdIn(List<Integer> ids);

    @Modifying
    @Query("UPDATE Customer SET email =:email WHERE id =:id")
    void upadateCustomerByEmail(@Param("email") String email, @Param("id") Integer id);
}
