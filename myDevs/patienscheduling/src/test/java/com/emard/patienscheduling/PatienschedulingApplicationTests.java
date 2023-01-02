package com.emard.patienscheduling;

import java.time.Instant;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.emard.patienscheduling.entities.Appointment;
import com.emard.patienscheduling.entities.Doctor;
import com.emard.patienscheduling.entities.Insurance;
import com.emard.patienscheduling.entities.Patient;
import com.emard.patienscheduling.repo.AppointementRepository;
import com.emard.patienscheduling.repo.DoctorRepository;
import com.emard.patienscheduling.repo.PatientRepository;

@SpringBootTest
class PatienschedulingApplicationTests {

	@Autowired DoctorRepository doctorRepository;
	@Autowired PatientRepository patientRepository;
	@Autowired AppointementRepository appointementRepository;
	@Test
	void testCreatedoctor() {
		Doctor doctor = Doctor.builder()
		.firstName("Tidiane")
		.lastName("Dramé")
		.speciality("All").build();
		doctorRepository.save(doctor);
	}

	@Test
	void createPatient(){
		Doctor doctor = doctorRepository.findById(1L).get();
		Insurance insurance = Insurance.builder()
		.providerName("Blue Cross Blue Shield")
		.copay(20d).build();
		Patient patient = Patient.builder()
		.firstName("Doug")
		.lastName("Bailey")
		.phone("123456789")
		.insurance(insurance)
		.doctors(List.of(doctor)).build();
		patientRepository.save(patient);
	}

	@Test
	void testCreateAppointement(){
		Appointment appointment = Appointment.builder()
		.appointmentTime(Instant.now().plus(7, ChronoUnit.DAYS))
		.reason("I have a problem")
		.started(true)
		.ended(false)
		.patient(patientRepository.findById(1L).get())
		.doctor(doctorRepository.findById(1L).get())
		.build();
		appointementRepository.save(appointment);
	}

}
