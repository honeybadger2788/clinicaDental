package com.example.clinicaDental.controller;

import com.example.clinicaDental.entity.Odontologo;
import com.example.clinicaDental.service.OdontologoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("odontologos")
public class OdontologoController {
    private final OdontologoService odontologoService;

    @Autowired
    public OdontologoController(OdontologoService odontologoService) {
        this.odontologoService = odontologoService;
    }

    @GetMapping
    public List<Odontologo> getOdontologos() {
        return odontologoService.listarOdontologos();
    }

    @GetMapping("/{id}")
    public ResponseEntity getOdontologo(@PathVariable Long id) {
        return new ResponseEntity<Odontologo>(odontologoService.buscarOdontologo(id), HttpStatus.OK);
    }

    @PostMapping("/crear")
    public ResponseEntity cargarOdontologo(@RequestBody Odontologo odontologo) {
        return new ResponseEntity<Odontologo>(odontologoService.cargarOdontologo(odontologo), HttpStatus.CREATED);
    }
}

