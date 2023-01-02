package com.emard.patienscheduling.entities;

import java.util.List;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
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
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String phone;
    @Embedded
    private Insurance insurance;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "patients_doctors", joinColumns = 
    @JoinColumn(name= "patient_id", referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(name= "doctor_id", referencedColumnName = "id"))
    private List<Doctor> doctors;
    @OneToMany
    private List<Appointment> appointments;
}
