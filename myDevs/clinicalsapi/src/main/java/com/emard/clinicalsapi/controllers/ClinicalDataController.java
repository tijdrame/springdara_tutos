package com.emard.clinicalsapi.controllers;

import java.time.Instant;
import java.util.Optional;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emard.clinicalsapi.dto.ClinicalDataRequest;
import com.emard.clinicalsapi.entities.ClinicalData;
import com.emard.clinicalsapi.entities.Patient;
import com.emard.clinicalsapi.repo.ClinicalDataRepository;
import com.emard.clinicalsapi.service.PatientService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/clinicals")
public class ClinicalDataController {
    private final ClinicalDataRepository repository;
    private final PatientService service;

    @PostMapping
    public ClinicalData saveClinicalData(@RequestBody ClinicalDataRequest request){
        Optional<Patient> patient = service.getPatient(request.getPatientId());
        ClinicalData clinicalData = new ClinicalData();
        if(patient.isEmpty()) {
            throw new RuntimeException("Patient avec id "+ request.getPatientId() + " non trouvé");
        }
        clinicalData.setPatient(patient.get());
        clinicalData.setComponentName(request.getComponentName());
        clinicalData.setComponentValue(request.getComponentValue());
        clinicalData.setMeasuredDateTime(Instant.now());
        return repository.save(clinicalData);
    }
}
