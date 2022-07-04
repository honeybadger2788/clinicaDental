package com.example.clinicaDental.dto;

import com.example.clinicaDental.entity.Address;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter @Setter
public class PatientDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private String dni;
    private String email;
    private LocalDate admissionDate;
    private Address address;
}
