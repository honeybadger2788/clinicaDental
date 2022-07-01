package com.example.clinicaDental.dto;

import com.example.clinicaDental.entity.Domicilio;
import lombok.*;

import java.time.LocalDate;

@Getter @Setter
public class PacienteDTO {
    private Long id;
    private String nombre;
    private String apellido;
    private String dni;
    private String email;
    private LocalDate fechaIngreso;
    // todo como hacer para que use un domicilioDTO
    private Domicilio domicilio;
}
