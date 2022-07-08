package com.example.clinicaDental.service.impl;

import com.example.clinicaDental.dto.AppointmentDTO;
import com.example.clinicaDental.dto.DentistDTO;
import com.example.clinicaDental.entity.Appointment;
import com.example.clinicaDental.service.IAppointmentService;
import com.example.clinicaDental.service.IDentistService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

class AppointmentServiceTest {

    @Autowired
    IAppointmentService appointmentService;

    @Test
    void listAppointments() {
        Collection<AppointmentDTO> appointments = appointmentService.listAppointments();
        assertTrue( appointments.size() > 0);
    }

}