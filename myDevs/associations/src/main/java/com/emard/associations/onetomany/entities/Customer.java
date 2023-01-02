package com.emard.associations.onetomany.entities;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private Set<PhoneNumber> numbers;

    public void addPhoneNumber(PhoneNumber number){
        if(number != null){
            if(numbers == null) {
                numbers = new HashSet<>();
            }
            number.setCustomer(this);
            numbers.add(number);
        }
    }
}
