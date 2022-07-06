package com.example.clinicaDental.controller;

import com.example.clinicaDental.dto.PatientDTO;
import com.example.clinicaDental.exceptions.BadRequestException;
import com.example.clinicaDental.exceptions.ResourceNotFoundException;
import com.example.clinicaDental.service.IPatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("patients")
public class PatientController {

    @Autowired
    // si hubiera muchas clasesService que implementen la misma interfaz, definiriamos cuál usar con el @Qualifier
    public IPatientService patientService;

    @GetMapping("/{id}")
    public ResponseEntity getPatient(@PathVariable Long id) throws ResourceNotFoundException {
        return new ResponseEntity<>(patientService.getPatient(id),HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity getAllPatients() {
        return new ResponseEntity<>(patientService.listPatients(),HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity postPatient(@RequestBody PatientDTO patientDTO) throws BadRequestException {
        // en el front muestra el mensaje pero da success
        patientService.addPatient(patientDTO);
        return new ResponseEntity<>("Patient created", HttpStatus.CREATED);
    }

    // se deberán ingresar tanto los campos a editar como los que se quieren preservar
    @PutMapping("/edit")
    public ResponseEntity putPatient(@RequestBody PatientDTO patientDTO) throws ResourceNotFoundException {
        patientService.editPatient(patientDTO);
        return new ResponseEntity<>("Patient edited", HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletePatient(@PathVariable Long id) throws ResourceNotFoundException {
        patientService.deletePatient(id);
        return new ResponseEntity<>("Patient deleted", HttpStatus.ACCEPTED);
    }
}
