package com.example.clinicaDental.controller;

import com.example.clinicaDental.dto.PacienteDTO;
import com.example.clinicaDental.service.IPacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("pacientes")
public class PacienteController {

    @Autowired
    // si hubiera muchas clasesService que implementen la misma interfaz, definiriamos cuál usar con el @Qualifier
    public IPacienteService pacienteService;

    @GetMapping("/{id}")
    public ResponseEntity getPaciente(@PathVariable Long id) {
        return new ResponseEntity<>(pacienteService.buscarPaciente(id),HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity getPacientes() {
        return new ResponseEntity<>(pacienteService.listarPacientes(),HttpStatus.OK);
    }

    @PostMapping("/crear")
    public ResponseEntity cargarPaciente(@RequestBody PacienteDTO pacienteDTO) {
        pacienteService.cargarPaciente(pacienteDTO);
        return new ResponseEntity<>("Paciente creado con exito", HttpStatus.CREATED);
    }
}
