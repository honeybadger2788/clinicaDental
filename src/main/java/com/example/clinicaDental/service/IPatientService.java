package com.example.clinicaDental.service;

import com.example.clinicaDental.dto.PatientDTO;

import java.util.*;

public interface IPatientService {
    public void addPatient(PatientDTO patientDTO);

    public PatientDTO getPatient(Long id);

    public Collection<PatientDTO> listPatients();

    public void editPatient(PatientDTO patientDTO);

    public void deletePatient(Long id);
}
