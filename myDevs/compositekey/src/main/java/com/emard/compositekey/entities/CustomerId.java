package com.emard.compositekey.entities;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter@Builder
@Setter
@Embeddable@NoArgsConstructor@AllArgsConstructor
public class CustomerId implements Serializable {
    private Integer id;
    private String name;
}
