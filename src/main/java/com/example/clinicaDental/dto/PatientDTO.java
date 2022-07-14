package com.example.clinicaDental.dto;

import com.example.clinicaDental.entity.Address;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Getter @Setter
public class PatientDTO {
    private Long id;
    @NotBlank
    private String firstName;
    @NotBlank
    private String lastName;
    @NotBlank
    private String dni;
    @NotBlank
    private String email;
    private LocalDate admissionDate;
    private Address address;
}
