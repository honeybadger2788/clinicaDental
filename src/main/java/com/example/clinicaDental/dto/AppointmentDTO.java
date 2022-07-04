package com.example.clinicaDental.dto;

import com.example.clinicaDental.entity.Dentist;
import com.example.clinicaDental.entity.Patient;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalTime;

@Getter @Setter
public class AppointmentDTO {
    private Long id;
    private String dateAppointment;
    private LocalTime timeAppointment;
    private Patient patient;
    private Dentist dentist;
}
