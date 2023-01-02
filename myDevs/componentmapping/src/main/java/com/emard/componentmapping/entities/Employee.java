package com.emard.componentmapping.entities;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter@Entity@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    @Id
    private Integer id;
    private String name;
    @Embedded
    private Address address;
}
