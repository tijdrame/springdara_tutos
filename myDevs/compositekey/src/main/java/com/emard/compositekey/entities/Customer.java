package com.emard.compositekey.entities;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter@Builder@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity@ToString
@Table(name = "customer1")
public class Customer {
    @EmbeddedId
    private CustomerId id;
    private String email;
}
