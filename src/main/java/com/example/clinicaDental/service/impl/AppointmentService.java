package com.example.clinicaDental.service.impl;

import com.example.clinicaDental.dto.AppointmentDTO;
import com.example.clinicaDental.entity.Appointment;
import com.example.clinicaDental.repository.IAppointmentRepository;
import com.example.clinicaDental.service.IAppointmentService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AppointmentService implements IAppointmentService {

    @Autowired
    IAppointmentRepository turnoRepository;

    @Autowired
    ObjectMapper mapper;


    @Override
    public Collection<AppointmentDTO> listAppointments() {
        Set<AppointmentDTO> turnosDTO = new HashSet<>();
        List<Appointment> appointments = turnoRepository.findAll();
        for (Appointment appointment :
                appointments) {
            turnosDTO.add(mapper.convertValue(appointment, AppointmentDTO.class));
        }
        return turnosDTO;
    }

    @Override
    public AppointmentDTO getAppointment(Long id) {
        AppointmentDTO appointmentDTO = null;
        Optional<Appointment> turno = turnoRepository.findById(id);
        if (turno.isPresent()) {
            appointmentDTO = mapper.convertValue(turno, AppointmentDTO.class);
        }
        return appointmentDTO;
    }

    @Override
    public void deleteAppointment(Long id) {
        turnoRepository.deleteById(id);
    }

    @Override
    public void addAppointment(AppointmentDTO appointmentDTO) {
        Appointment appointment = mapper.convertValue(appointmentDTO, Appointment.class);
        turnoRepository.save(appointment);
    }

    @Override
    public void editAppointment(AppointmentDTO appointmentDTO) {
        Appointment appointment = mapper.convertValue(appointmentDTO, Appointment.class);
        turnoRepository.save(appointment);
    }
}
