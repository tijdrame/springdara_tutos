package com.emard.mongodemo.entities;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter@Builder@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document@ToString
public class Product {
    private String id;
    private String name;
    private Float price;
}
