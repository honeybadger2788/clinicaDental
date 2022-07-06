package com.example.clinicaDental.service.impl;

import com.example.clinicaDental.dto.PatientDTO;
import com.example.clinicaDental.entity.Patient;
import com.example.clinicaDental.exceptions.BadRequestException;
import com.example.clinicaDental.exceptions.ResourceNotFoundException;
import com.example.clinicaDental.repository.IPatientRepository;
import com.example.clinicaDental.service.IPatientService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PatientService implements IPatientService {

    // reemplaza al
    // private static IDao<Paciente> pacienteDao = new PacienteDao();
    @Autowired
    IPatientRepository patientRepository;

    /* reemplaza a
    public PacienteService(IDao<Paciente> pacienteDao) {
        this.pacienteDao = pacienteDao;
    }

    public void setpacienteDao( IDao<Paciente> pacienteDao) {
        this.pacienteDao = pacienteDao;
    }*/
    @Autowired
    ObjectMapper mapper;

    @Override
    public void addPatient(PatientDTO patientDTO) throws BadRequestException {
        // como recibo un pacienteDTO, debo mappear el objeto antes de poder cargarlo
        // el mapper sirve para asignar los valores del dto al paciente
        if(patientRepository.getPatientByDni(patientDTO.getDni()) != null)
            throw new BadRequestException("Patient already exist");
        Patient patient = mapper.convertValue(patientDTO, Patient.class);
        patientRepository.save(patient);
    }

    @Override
    public PatientDTO getPatient(Long id) throws ResourceNotFoundException {
        PatientDTO patientDTO = null;
        // lo hace opcional porque puede ser nulo
        Optional<Patient> patient = patientRepository.findById(id);
        if (patient.isPresent()){
            // para convertir un paciente a un pacienteDTO
            patientDTO = mapper.convertValue(patient, PatientDTO.class);
        } else {
            throw new ResourceNotFoundException("Patient Not Found");
        }
        return patientDTO;
    }

    @Override
    public Collection<PatientDTO> listPatients(){
        Set<PatientDTO> patientsDTO = new HashSet<>();
        List<Patient> patients = patientRepository.findAll();
        for (Patient patient :
                patients) {
            patientsDTO.add(mapper.convertValue(patient, PatientDTO.class));
        }
        return patientsDTO;
    }

    @Override
    public void editPatient(PatientDTO patientDTO) throws ResourceNotFoundException {
        if(getPatient(patientDTO.getId()) == null)
            throw new ResourceNotFoundException("Patient Not Found");
        Patient patient = mapper.convertValue(patientDTO, Patient.class);
        patientRepository.save(patient);
    }

    @Override
    public void deletePatient(Long id) throws ResourceNotFoundException {
        if(getPatient(id) == null)
            throw new ResourceNotFoundException("Patient Not Found");
        patientRepository.deleteById(id);
    }

}
