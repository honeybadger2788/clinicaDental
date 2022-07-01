package com.example.clinicaDental.dto;

import com.example.clinicaDental.entity.Odontologo;
import com.example.clinicaDental.entity.Paciente;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter @Setter
public class TurnoDTO {
    private Long id;
    private LocalDate fechaTurno;
    private LocalTime horaTurno;
    private Paciente paciente;
    private Odontologo odontologo;
}
