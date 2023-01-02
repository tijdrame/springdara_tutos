package com.emard.productdata.repo;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.repository.CrudRepository;
//import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.jpa.repository.Query;

import com.emard.productdata.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    List<Product> findByName(String name);
    List<Product> findByNameAndDesc(String name, String desc);
    List<Product> findByPriceGreaterThan(Double price);
    List<Product> findByDescContains(String desc);
    List<Product> findByPriceBetween(Double min, Double max);
    List<Product> findByDescLike(String desc);
    List<Product> findByIdIn(List<Integer> ids, Pageable pageable);
    @Query(value = "CALL GetAllProducts", nativeQuery = true)
    List<Product> findAllProducts();

    @Query(value = "CALL GetAllProductsByPrice(:price_in)", nativeQuery = true)
    List<Product> findAllProductsByPrice(double price_in);

    @Query(value = "CALL GetAllProductsCountByPrice(:price_in)", nativeQuery = true)
    Integer findAllProductsCountByPrice(double price_in);

}
