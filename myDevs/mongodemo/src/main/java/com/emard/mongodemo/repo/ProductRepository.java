package com.emard.mongodemo.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.emard.mongodemo.entities.Product;

public interface ProductRepository extends MongoRepository<Product, String> {
    
}
