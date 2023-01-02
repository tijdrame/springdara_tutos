package com.emard.productdata.entities;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter@Builder
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class Address {
    private String streetaddress;
    private String city;
    private String state;
    private String zipcode;
    private String country;
}
