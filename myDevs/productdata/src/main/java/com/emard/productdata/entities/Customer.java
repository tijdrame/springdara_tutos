package com.emard.productdata.entities;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Customer {
    @Id
    private Integer id;
    private String name;
    private String email;
    @Embedded
    private Address address;
}
