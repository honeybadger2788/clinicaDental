package com.example.clinicaDental.controller;

import com.example.clinicaDental.entity.Turno;
import com.example.clinicaDental.service.TurnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("turnos")
public class TurnoController {

    private final TurnoService turnoService;

    @Autowired
    public TurnoController(TurnoService turnoService) {
        this.turnoService = turnoService;
    }

    @GetMapping
    public List<Turno> getTurnos() {
        return turnoService.listarTurnos();
    }

    @PostMapping("/crear")
    public ResponseEntity cargarTurno(@RequestBody Turno turno) {
        return new ResponseEntity<Turno>(turnoService.cargarTurno(turno), HttpStatus.CREATED);
    }
}
