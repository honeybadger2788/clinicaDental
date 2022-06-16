package com.example.clinicaDental.controller;

import com.example.clinicaDental.model.Paciente;
import com.example.clinicaDental.model.Turno;
import com.example.clinicaDental.service.TurnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalTime;
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

    /* NO ESTÁ FUNCIONANDO */
    @PostMapping("/crear")
    public ResponseEntity cargarTurno(@RequestBody Long id, LocalDate fechaTurno, LocalTime horaTurno, Long idP, Long idO) {
        return new ResponseEntity<Turno>(turnoService.cargarTurno(id, fechaTurno, horaTurno, idP, idO), HttpStatus.CREATED);
    }
}
