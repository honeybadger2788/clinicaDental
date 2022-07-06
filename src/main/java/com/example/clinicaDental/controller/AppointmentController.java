package com.example.clinicaDental.controller;

import com.example.clinicaDental.dto.AppointmentDTO;
import com.example.clinicaDental.exceptions.ResourceNotFoundException;
import com.example.clinicaDental.service.IAppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("appointments")
public class AppointmentController {

    @Autowired
    public IAppointmentService appointmentService;

    @GetMapping
    public Collection<AppointmentDTO> getAllAppointments() {
        return appointmentService.listAppointments();
    }

    @PostMapping("/add")
    public ResponseEntity addAppointment(@RequestBody AppointmentDTO appointmentDTO) throws ResourceNotFoundException {
        appointmentService.addAppointment(appointmentDTO);
        return new ResponseEntity<>("Appointment created", HttpStatus.CREATED);
    }

    @PutMapping("/edit")
    public ResponseEntity putAppointment(@RequestBody AppointmentDTO appointmentDTO) throws ResourceNotFoundException {
        appointmentService.editAppointment(appointmentDTO);
        return new ResponseEntity<>("Appointment edited", HttpStatus.ACCEPTED);
    }

    @GetMapping("/{id}")
    public ResponseEntity getAppointment(@PathVariable Long id) throws ResourceNotFoundException {
        return new ResponseEntity<>(appointmentService.getAppointment(id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteAppointment(@PathVariable Long id) throws ResourceNotFoundException {
        appointmentService.deleteAppointment(id);
        return new ResponseEntity<>("Appointment deleted", HttpStatus.ACCEPTED);
    }
}
