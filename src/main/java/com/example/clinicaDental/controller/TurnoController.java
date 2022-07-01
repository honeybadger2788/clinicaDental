package com.example.clinicaDental.controller;

import com.example.clinicaDental.dto.TurnoDTO;
import com.example.clinicaDental.entity.Turno;
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

    @PutMapping("/editar")
    public ResponseEntity editarTurno(@RequestBody TurnoDTO turnoDTO){
        turnoService.actualizarTurno(turnoDTO);
        return new ResponseEntity<>("Turno actualizado con exito", HttpStatus.ACCEPTED);
    }

    @GetMapping("/{id}")
    public ResponseEntity getTurno(@PathVariable Long id) {
        return new ResponseEntity<>(turnoService.buscarTurno(id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteTurno(@PathVariable Long id) {
        turnoService.eliminarTurno(id);
        return new ResponseEntity<>("Turno eliminado con exito", HttpStatus.ACCEPTED);
    }
}
