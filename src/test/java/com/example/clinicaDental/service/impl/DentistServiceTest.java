package com.example.clinicaDental.service.impl;

import com.example.clinicaDental.dto.DentistDTO;
import com.example.clinicaDental.dto.PatientDTO;
import com.example.clinicaDental.entity.Address;
import com.example.clinicaDental.exceptions.BadRequestException;
import com.example.clinicaDental.exceptions.ResourceNotFoundException;
import com.example.clinicaDental.service.IDentistService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DentistServiceTest {

    @Autowired
    IDentistService dentistService;

    @Test
    void listDentists() {
        Collection<DentistDTO> dentists = dentistService.listDentists();
        assertTrue( dentists.size() > 0);
    }

    @Test
    void findByDni() throws BadRequestException, ResourceNotFoundException {
        DentistDTO dentistDTO = new DentistDTO();
        dentistDTO.setFirstName("Test");
        dentistDTO.setLastName("Test");
        dentistDTO.setLicence("123Test");

        dentistService.addDentist(dentistDTO);

        Collection<DentistDTO> dentists = dentistService.findByLicence(dentistDTO.getLicence());
        assertTrue(dentists.size()>0);
        for (DentistDTO dentist:
                dentists) {
            dentistService.deleteDentist(dentist.getId());
        }
    }
}