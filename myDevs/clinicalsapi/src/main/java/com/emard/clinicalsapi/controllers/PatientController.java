package com.emard.clinicalsapi.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emard.clinicalsapi.entities.ClinicalData;
import com.emard.clinicalsapi.entities.Patient;
import com.emard.clinicalsapi.service.PatientService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/patients")
public class PatientController {
    
    private final PatientService patientService;

    @GetMapping
    public ResponseEntity<List<Patient>> getPatients() {
        return ResponseEntity.ok().body(patientService.getPatients());
    }

    @GetMapping("/{id}")
    public Patient getPatientById(@PathVariable Long id) {
        Optional<Patient> patientOp = patientService.getPatient(id);
        if(patientOp.isPresent()){
            return patientOp.get();
        }else {
            return null;
        }
    }

    @PostMapping
    public Patient savePatient(@RequestBody Patient patient){
        return patientService.savePatient(patient);
    }

    @PutMapping("/{id}")
    public Patient updatePatient(@PathVariable Long id, @RequestBody Patient patient){
        return patientService.updatePatient(id, patient);
    }

    @GetMapping("/analyse/{id}")
    public Patient analyse(@PathVariable Long id) {
        Optional<Patient> patientOp = patientService.getPatient(id);
        if(patientOp.isEmpty()){
            throw new RuntimeException("Patient avec id "+ id + " non trouvé");
        }
        ClinicalData data = patientOp.get().getClinicalDatas().stream().filter (c-> c.getComponentName().equals("hw")).findFirst().orElse(null);
        
        if(data != null){
            String[] heaightAndWeight = data.getComponentValue().split("/");
            Float heightInMeters = Float.parseFloat(heaightAndWeight[0]) * 0.4536F;
            Float bmi = Float.parseFloat(heaightAndWeight[1]) / (heightInMeters * heightInMeters);
            data.setComponentName("bmi");
            data.setComponentValue(Float.toString(bmi));
            patientOp.get().getClinicalDatas().add(data);

        }
        return patientOp.get();
    }

}
