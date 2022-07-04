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
    IDentistRepository dentistRepository;

    @Autowired
    ObjectMapper mapper;

    @Override
    public void addDentist(DentistDTO dentistDTO) {
        Dentist dentist = mapper.convertValue(dentistDTO, Dentist.class);
        dentistRepository.save(dentist);
    }

    @Override
    public DentistDTO getDentist(Long id) {
        DentistDTO dentistDTO = null;
        Optional<Dentist> dentist = dentistRepository.findById(id);
        if (dentist.isPresent()) {
            dentistDTO = mapper.convertValue(dentist, DentistDTO.class);
        }
        return dentistDTO;
    }

    @Override
    public Collection<DentistDTO> listDentists() {
        Set<DentistDTO> dentistsDTO = new HashSet<>();
        List<Dentist> dentists = dentistRepository.findAll();
        for (Dentist dentist :
                dentists) {
            dentistsDTO.add(mapper.convertValue(dentist, DentistDTO.class));
        }
        return dentistsDTO;
    }

    @Override
    public void editDentist(DentistDTO dentistDTO) {
        Dentist dentist = mapper.convertValue(dentistDTO, Dentist.class);
        dentistRepository.save(dentist);
    }

    @Override
    public void deleteDentist(Long id) {
        dentistRepository.deleteById(id);
    }
}


