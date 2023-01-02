package com.emard.clinicalsapi.service;

import java.util.List;
import java.util.Optional;

import com.emard.clinicalsapi.entities.Patient;

public interface PatientService {
    List<Patient> getPatients();
    Optional<Patient> getPatient(Long id);
    Patient savePatient(Patient patient);
    Patient updatePatient(Long id, Patient patient);
    void deletePatient(Long id);
}
