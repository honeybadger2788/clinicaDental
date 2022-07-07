package com.example.clinicaDental.service.impl;

import com.example.clinicaDental.dto.PatientDTO;
import com.example.clinicaDental.entity.Address;
import com.example.clinicaDental.entity.Patient;
import com.example.clinicaDental.exceptions.BadRequestException;
import com.example.clinicaDental.exceptions.ResourceNotFoundException;
import com.example.clinicaDental.repository.IPatientRepository;
import com.example.clinicaDental.service.IPatientService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PatientServiceTest {
    @Autowired
    IPatientService patientService;

    @Test
    void getPatient() throws BadRequestException, ResourceNotFoundException {
        /*PatientDTO patientDTO = new PatientDTO();
        patientDTO.setFirstName("Test");
        patientDTO.setLastName("Test");
        patientDTO.setDni("99999");
        patientDTO.setAddress(new Address("Test", 123, "Test","Test"));

        patientService.addPatient(patientDTO);
        PatientDTO patient = patientService.getPatient(patientDTO.getId());
        assertTrue(patient.equals(patientDTO));*/
    }

    @Test
    void listPatients() {
    }

    @Test
    void editPatient() {
    }

    @Test
    void deletePatient() {
    }
}