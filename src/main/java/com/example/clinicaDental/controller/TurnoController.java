package com.example.clinicaDental.controller;

import com.example.clinicaDental.dto.TurnoDTO;
import com.example.clinicaDental.service.ITurnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("turnos")
public class TurnoController {

    @Autowired
    public ITurnoService turnoService;

    @GetMapping
    public Collection<TurnoDTO> getTurnos() {
        return turnoService.listarTurnos();
    }

    @PostMapping("/crear")
    public ResponseEntity cargarTurno(@RequestBody TurnoDTO turnoDTO) {
        turnoService.cargarTurno(turnoDTO);
        return new ResponseEntity<>("Turno creado con exito", HttpStatus.CREATED);
    }
}
