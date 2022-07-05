package com.example.clinicaDental.service;

import com.example.clinicaDental.dto.PatientDTO;
import com.example.clinicaDental.exceptions.ResourceNotFoundException;

import java.util.Collection;

public interface IPatientService {
    public void addPatient(PatientDTO patientDTO);

    public PatientDTO getPatient(Long id) throws ResourceNotFoundException;

    public Collection<PatientDTO> listPatients();

    public void editPatient(PatientDTO patientDTO) throws ResourceNotFoundException;

    public void deletePatient(Long id) throws ResourceNotFoundException;
}
