package com.example.clinicaDental.service;

import com.example.clinicaDental.dto.DentistDTO;
import com.example.clinicaDental.entity.Dentist;
import com.example.clinicaDental.exceptions.BadRequestException;
import com.example.clinicaDental.exceptions.ResourceNotFoundException;

import java.util.Collection;
import java.util.Optional;

public interface IDentistService {
    public void addDentist(DentistDTO dentistDTO) throws BadRequestException;

    public DentistDTO getDentist(Long id) throws ResourceNotFoundException;

    public Collection<DentistDTO> listDentists();

    public void editDentist(DentistDTO dentistDTO) throws ResourceNotFoundException;

    public void deleteDentist(Long id) throws ResourceNotFoundException;

    public Optional<DentistDTO> findByLicence(String licence);
}
