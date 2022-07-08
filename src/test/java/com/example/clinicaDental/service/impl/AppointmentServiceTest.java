package com.example.clinicaDental.service.impl;

import com.example.clinicaDental.dto.AppointmentDTO;
import com.example.clinicaDental.service.IAppointmentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class AppointmentServiceTest {

    @Autowired
    IAppointmentService appointmentService;

    @Test
    void listAppointments() {
        Collection<AppointmentDTO> appointments = appointmentService.listAppointments();
        assertTrue( appointments.size() > 0);
    }

}