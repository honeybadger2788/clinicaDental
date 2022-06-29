package com.example.clinicaDental.controller;

import com.example.clinicaDental.dto.PacienteDTO;
import com.example.clinicaDental.service.IPacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("pacientes")
public class PacienteController {

    @Autowired
    // si hubiera muchas clases que implementes la misma interfaz, definiriamos cuál usar con el @Qualifier
    public IPacienteService pacienteService;

    @GetMapping
    public ResponseEntity<?> getPacientes() {
        return new ResponseEntity<>(pacienteService.listarPacientes(),HttpStatus.OK);
    }

    @PostMapping("/crear")
    public ResponseEntity<?> cargarPaciente(@RequestBody PacienteDTO pacienteDTO) {
        pacienteService.cargarPaciente(pacienteDTO);
        return new ResponseEntity<>("Paciente creado con exito", HttpStatus.CREATED);
    }
}
