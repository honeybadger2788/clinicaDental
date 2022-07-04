package com.example.clinicaDental.service.impl;

import com.example.clinicaDental.dto.DentistDTO;
import com.example.clinicaDental.entity.Dentist;
import com.example.clinicaDental.repository.IDentistRepository;
import com.example.clinicaDental.service.IDentistService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class DentistService implements IDentistService {
    @Autowired
    IDentistRepository odontologoRepository;

    @Autowired
    ObjectMapper mapper;

    @Override
    public void addDentist(DentistDTO dentistDTO) {
        Dentist dentist = mapper.convertValue(dentistDTO, Dentist.class);
        odontologoRepository.save(dentist);
    }

    @Override
    public DentistDTO getDentist(Long id) {
        DentistDTO dentistDTO = null;
        Optional<Dentist> odontologo = odontologoRepository.findById(id);
        if (odontologo.isPresent()) {
            dentistDTO = mapper.convertValue(odontologo, DentistDTO.class);
        }
        return dentistDTO;
    }

    @Override
    public Collection<DentistDTO> listDentists() {
        Set<DentistDTO> odontologosDTO = new HashSet<>();
        List<Dentist> dentists = odontologoRepository.findAll();
        for (Dentist dentist :
                dentists) {
            odontologosDTO.add(mapper.convertValue(dentist, DentistDTO.class));
        }
        return odontologosDTO;
    }

    @Override
    public void editDentist(DentistDTO dentistDTO) {
        Dentist dentist = mapper.convertValue(dentistDTO, Dentist.class);
        odontologoRepository.save(dentist);
    }

    @Override
    public void deleteDentist(Long id) {
        odontologoRepository.deleteById(id);
    }
}


