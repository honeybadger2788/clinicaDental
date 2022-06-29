package com.example.clinicaDental.controller;

import com.example.clinicaDental.entity.Paciente;
import com.example.clinicaDental.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("pacientes")
public class PacienteController {

    private final PacienteService pacienteService;

    @Autowired
    public PacienteController(PacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }

    @GetMapping
    public List<Paciente> getPacientes() {
        return pacienteService.listarPacientes();
    }

    @PostMapping("/crear")
    public ResponseEntity cargarPaciente(@RequestBody Paciente paciente) {
        return new ResponseEntity<Paciente>(pacienteService.cargarPaciente(paciente), HttpStatus.CREATED);
    }
}
