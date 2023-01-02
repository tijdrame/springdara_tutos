package com.emard.patienscheduling.entities;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter@Builder@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Embeddable
public class Insurance {
    private String providerName;
    private Double copay;
}
