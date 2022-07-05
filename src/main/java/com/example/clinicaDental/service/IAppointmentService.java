package com.example.clinicaDental.service;

import com.example.clinicaDental.dto.AppointmentDTO;
import com.example.clinicaDental.exceptions.ResourceNotFoundException;

import java.util.Collection;

public interface IAppointmentService {
    public Collection<AppointmentDTO> listAppointments();

    public AppointmentDTO getAppointment(Long id) throws ResourceNotFoundException;

    public void deleteAppointment(Long id) throws ResourceNotFoundException;

    public void addAppointment(AppointmentDTO appointmentDTO);

    public void editAppointment(AppointmentDTO appointmentDTO) throws ResourceNotFoundException;
}
