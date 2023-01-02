package com.emard.productdata.entities;

import java.io.Serializable;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
public class Product implements Serializable {
    @Id
    private Integer id;
    private String name;
    @Column(name = "description")
    private String desc;
    private Double price;

}
