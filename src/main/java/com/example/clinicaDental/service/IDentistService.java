package com.example.clinicaDental.service;

import com.example.clinicaDental.dto.DentistDTO;

import java.util.Collection;

public interface IDentistService {
    public void addDentist(DentistDTO dentistDTO);

    public DentistDTO getDentist(Long id);

    public Collection<DentistDTO> listDentists();

    public void editDentist(DentistDTO dentistDTO);

    public void deleteDentist(Long id);
}
