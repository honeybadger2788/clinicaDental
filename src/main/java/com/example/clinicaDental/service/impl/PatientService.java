package com.example.clinicaDental.service.impl;

import com.example.clinicaDental.dto.PatientDTO;
import com.example.clinicaDental.entity.Patient;
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
    IPatientRepository pacienteRepository;

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
    public void addPatient(PatientDTO patientDTO){
        // como recibo un pacienteDTO, debo mappear el objeto antes de poder cargarlo
        // el mapper sirve para asignar los valores del dto al paciente
        Patient patient = mapper.convertValue(patientDTO, Patient.class);
        pacienteRepository.save(patient);
    }

    @Override
    public PatientDTO getPatient(Long id){
        PatientDTO patientDTO = null;
        // lo hace opcional porque puede ser nulo
        Optional<Patient> paciente = pacienteRepository.findById(id);
        if (paciente.isPresent()){
            // para convertir un paciente a un pacienteDTO
            patientDTO = mapper.convertValue(paciente, PatientDTO.class);
        }
        return patientDTO;
    }

    @Override
    public Collection<PatientDTO> listPatients(){
        Set<PatientDTO> pacientesDTO = new HashSet<>();
        List<Patient> patients = pacienteRepository.findAll();
        for (Patient patient :
                patients) {
            pacientesDTO.add(mapper.convertValue(patient, PatientDTO.class));
        }
        return pacientesDTO;
    }

    @Override
    public void editPatient(PatientDTO patientDTO){
        Patient patient = mapper.convertValue(patientDTO, Patient.class);
        pacienteRepository.save(patient);
    }

    @Override
    public void deletePatient(Long id){
        pacienteRepository.deleteById(id);
    }

}
