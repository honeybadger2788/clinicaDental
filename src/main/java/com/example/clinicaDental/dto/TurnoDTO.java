package com.example.clinicaDental.dto;

import com.example.clinicaDental.entity.Odontologo;
import com.example.clinicaDental.entity.Paciente;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalTime;

@Getter @Setter
public class TurnoDTO {
    private Long id;
    private String fechaTurno;
    private LocalTime horaTurno;
    private Paciente paciente;
    private Odontologo odontologo;
}
