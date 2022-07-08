package com.example.clinicaDental.service.impl;

import com.example.clinicaDental.dto.PatientDTO;
import com.example.clinicaDental.entity.Address;
import com.example.clinicaDental.entity.Patient;
import com.example.clinicaDental.exceptions.BadRequestException;
import com.example.clinicaDental.exceptions.ResourceNotFoundException;
import com.example.clinicaDental.repository.IPatientRepository;
import com.example.clinicaDental.service.IPatientService;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collection;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PatientServiceTest {
    @Autowired
    IPatientService patientService;

    @Test
    void listPatients() {
        Collection<PatientDTO> patients = patientService.listPatients();
        assertTrue( patients.size()>0);
    }

    @Test
    void findByDni() throws BadRequestException, ResourceNotFoundException {
        PatientDTO patientDTO = new PatientDTO();
        patientDTO.setFirstName("Test");
        patientDTO.setLastName("Test");
        patientDTO.setDni("123Test");
        patientDTO.setEmail("Test@test.com");
        patientDTO.setAddress(new Address("Test",123,"Test","Test"));

        patientService.addPatient(patientDTO);

        Optional<PatientDTO> patientDTOFound = patientService.findByDni(patientDTO.getDni());
        assertNotNull(patientDTOFound);

        patientService.deletePatient(patientDTOFound.get().getId());
    }
}