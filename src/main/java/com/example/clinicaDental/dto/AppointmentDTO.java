package com.example.clinicaDental.dto;

import com.example.clinicaDental.entity.Dentist;
import com.example.clinicaDental.entity.Patient;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.time.LocalTime;

@Getter @Setter
public class AppointmentDTO {
    private Long id;
    @NotBlank
    private String dateAppointment;
    @NotBlank
    private LocalTime timeAppointment;
    @NotBlank
    private Patient patient;
    @NotBlank
    private Dentist dentist;
}
