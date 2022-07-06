package com.example.clinicaDental.service.impl;

import com.example.clinicaDental.dto.AppointmentDTO;
import com.example.clinicaDental.entity.Appointment;
import com.example.clinicaDental.exceptions.ResourceNotFoundException;
import com.example.clinicaDental.repository.IAppointmentRepository;
import com.example.clinicaDental.repository.IPatientRepository;
import com.example.clinicaDental.service.IAppointmentService;
import com.example.clinicaDental.service.IDentistService;
import com.example.clinicaDental.service.IPatientService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AppointmentService implements IAppointmentService {

    @Autowired
    IAppointmentRepository appointmentRepository;

    // inicialia los servicios de paciente y odontologo para usarlos como validacion al crear un nuevo turno
    @Autowired
    IPatientService patientService;
    @Autowired
    IDentistService dentistService;

    @Autowired
    ObjectMapper mapper;


    @Override
    public Collection<AppointmentDTO> listAppointments() {
        Set<AppointmentDTO> appointmentDTO = new HashSet<>();
        List<Appointment> appointments = appointmentRepository.findAll();
        for (Appointment appointment :
                appointments) {
            appointmentDTO.add(mapper.convertValue(appointment, AppointmentDTO.class));
        }
        return appointmentDTO;
    }

    @Override
    public AppointmentDTO getAppointment(Long id) throws ResourceNotFoundException {
        AppointmentDTO appointmentDTO = null;
        Optional<Appointment> appointment = appointmentRepository.findById(id);
        if (appointment.isPresent()) {
            appointmentDTO = mapper.convertValue(appointment, AppointmentDTO.class);
        } else {
            throw new ResourceNotFoundException("Appointment Not Found");
        }
        return appointmentDTO;
    }

    @Override
    public void deleteAppointment(Long id) throws ResourceNotFoundException {
        if(getAppointment(id) == null )
            throw new ResourceNotFoundException("Appointment Not Found");
        appointmentRepository.deleteById(id);
    }

    @Override
    public void addAppointment(AppointmentDTO appointmentDTO) throws ResourceNotFoundException {
        if (patientService.getPatient(appointmentDTO.getPatient().getId()) == null)
            throw new ResourceNotFoundException("Patient Not Found");
        else if (dentistService.getDentist(appointmentDTO.getDentist().getId()) == null)
            throw new ResourceNotFoundException("Dentist Not Found");
        Appointment appointment = mapper.convertValue(appointmentDTO, Appointment.class);
        appointmentRepository.save(appointment);
    }

    @Override
    public void editAppointment(AppointmentDTO appointmentDTO) throws ResourceNotFoundException {
        if(getAppointment(appointmentDTO.getId()) == null)
            throw new ResourceNotFoundException("Appointment Not Found");
        Appointment appointment = mapper.convertValue(appointmentDTO, Appointment.class);
        appointmentRepository.save(appointment);
    }
}
