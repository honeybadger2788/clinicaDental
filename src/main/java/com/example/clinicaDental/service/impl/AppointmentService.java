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
    IAppointmentRepository appointmentRepository;

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
    public AppointmentDTO getAppointment(Long id) {
        AppointmentDTO appointmentDTO = null;
        Optional<Appointment> appointment = appointmentRepository.findById(id);
        if (appointment.isPresent()) {
            appointmentDTO = mapper.convertValue(appointment, AppointmentDTO.class);
        }
        return appointmentDTO;
    }

    @Override
    public void deleteAppointment(Long id) {
        appointmentRepository.deleteById(id);
    }

    @Override
    public void addAppointment(AppointmentDTO appointmentDTO) {
        Appointment appointment = mapper.convertValue(appointmentDTO, Appointment.class);
        appointmentRepository.save(appointment);
    }

    @Override
    public void editAppointment(AppointmentDTO appointmentDTO) {
        Appointment appointment = mapper.convertValue(appointmentDTO, Appointment.class);
        appointmentRepository.save(appointment);
    }
}
