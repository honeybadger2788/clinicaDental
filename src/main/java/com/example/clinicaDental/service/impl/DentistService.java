package com.example.clinicaDental.service.impl;

import com.example.clinicaDental.dto.DentistDTO;
import com.example.clinicaDental.entity.Dentist;
import com.example.clinicaDental.exceptions.BadRequestException;
import com.example.clinicaDental.exceptions.ResourceNotFoundException;
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
    public Optional<DentistDTO> findByLicence(String licence) {
        Optional<Dentist> dentist = dentistRepository.findByLicence(licence);
        if(dentist.isPresent()){
            DentistDTO dentistDTO = mapper.convertValue(dentist, DentistDTO.class);
            return Optional.ofNullable(dentistDTO);
        }
        return null;
    }

    @Override
    public void addDentist(DentistDTO dentistDTO) throws BadRequestException {
        if(findByLicence(dentistDTO.getLicence()).isPresent())
            throw new BadRequestException("Dentist already exist");
        Dentist dentist = mapper.convertValue(dentistDTO, Dentist.class);
        dentistRepository.save(dentist);
    }

    @Override
    public DentistDTO getDentist(Long id) throws ResourceNotFoundException{
        DentistDTO dentistDTO = null;
        Optional<Dentist> dentist = dentistRepository.findById(id);
        if (dentist.isPresent()) {
            dentistDTO = mapper.convertValue(dentist, DentistDTO.class);
        } else {
            throw new ResourceNotFoundException("Dentist Not Found");
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
    public void editDentist(DentistDTO dentistDTO) throws ResourceNotFoundException {
        if(getDentist(dentistDTO.getId()) == null)
            throw new ResourceNotFoundException("Dentist Not Found");
        Dentist dentist = mapper.convertValue(dentistDTO, Dentist.class);
        dentistRepository.save(dentist);
    }

    @Override
    public void deleteDentist(Long id) throws ResourceNotFoundException {
        if(getDentist(id) == null)
            throw new ResourceNotFoundException("Dentist Not Found");
        dentistRepository.deleteById(id);
    }
}


