package com.example.clinicaDental.service;

import com.example.clinicaDental.dto.AppointmentDTO;

import java.util.Collection;

public interface IAppointmentService {
    public Collection<AppointmentDTO> listAppointments();

    public AppointmentDTO getAppointment(Long id);

    public void deleteAppointment(Long id);

    public void addAppointment(AppointmentDTO appointmentDTO);

    public void editAppointment(AppointmentDTO appointmentDTO);
}
