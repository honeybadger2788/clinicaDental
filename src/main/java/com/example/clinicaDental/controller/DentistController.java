package com.example.clinicaDental.controller;

import com.example.clinicaDental.dto.DentistDTO;
import com.example.clinicaDental.exceptions.BadRequestException;
import com.example.clinicaDental.exceptions.ResourceNotFoundException;
import com.example.clinicaDental.service.IDentistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("dentists")
public class DentistController {
    @Autowired
    public IDentistService dentistService;

    @GetMapping
    public Collection<DentistDTO> getAllDentists() {
        return dentistService.listDentists();
    }

    @GetMapping("/{id}")
    public ResponseEntity getDentist(@PathVariable Long id) throws ResourceNotFoundException {
        return new ResponseEntity<>(dentistService.getDentist(id), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity postDentist(@RequestBody DentistDTO dentistDTO) throws BadRequestException {
        dentistService.addDentist(dentistDTO);
        return new ResponseEntity("Dentist created", HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteDentist(@PathVariable Long id) throws ResourceNotFoundException {
        dentistService.deleteDentist(id);
        return new ResponseEntity<>("Dentist deleted", HttpStatus.ACCEPTED);
    }

    @PutMapping("/edit")
    public ResponseEntity putDentist(@RequestBody DentistDTO dentistDTO) throws ResourceNotFoundException {
        dentistService.editDentist(dentistDTO);
        return new ResponseEntity<>("Dentist edited", HttpStatus.CREATED);
    }
}

