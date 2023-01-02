package com.emard.clinicalsapi.service;

import java.util.List;
import java.util.Optional;

import javax.naming.NameNotFoundException;

import org.springframework.stereotype.Service;

import com.emard.clinicalsapi.entities.Patient;
import com.emard.clinicalsapi.repo.PatientRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class PatientServiceImpl implements PatientService {

    private final PatientRepository repository;

    @Override
    public List<Patient> getPatients() {
        return repository.findAll();
    }

    @Override
    public Optional<Patient> getPatient(Long id) {
        return repository.findById(id);
    }

    @Override
    public Patient savePatient(Patient patient) {
        return repository.save(patient);
    }

    @Override
    public Patient updatePatient(Long id, Patient patient)  {
        Patient dbPatient = repository.findById(id).get();
        if(dbPatient==null) {
            throw new RuntimeException("Patient avec id "+ id + " non trouvé");
        }
        patient.setId(id);
        return repository.save(patient);
    }

    @Override
    public void deletePatient(Long id) {
        repository.deleteById(id);
    }
    
}
