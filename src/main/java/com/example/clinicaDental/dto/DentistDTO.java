package com.example.clinicaDental.dto;

import com.sun.istack.NotNull;
import lombok.*;

import javax.validation.constraints.NotBlank;

@Getter @Setter
public class DentistDTO {
    private Long id;
    @NotBlank
    private String licence;
    @NotBlank
    private String firstName;
    @NotBlank
    private String lastName;
}
