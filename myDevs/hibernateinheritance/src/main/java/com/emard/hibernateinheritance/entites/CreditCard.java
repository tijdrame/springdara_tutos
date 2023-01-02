package com.emard.hibernateinheritance.entites;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter@Setter@ToString
@NoArgsConstructor
@Entity@Table(name = "card")
@PrimaryKeyJoinColumn(name = "id")
public class CreditCard extends Payment{
    @Column(name = "cardnumber")
    private String creditCard;
}
