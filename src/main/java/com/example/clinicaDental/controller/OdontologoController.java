package com.example.clinicaDental.controller;

import com.example.clinicaDental.dto.OdontologoDTO;
import com.example.clinicaDental.service.IOdontologoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("odontologos")
public class OdontologoController {
    @Autowired
    public IOdontologoService odontologoService;

    @GetMapping
    public Collection<OdontologoDTO> getOdontologos() {
        return odontologoService.listarOdontologos();
    }

    @GetMapping("/{id}")
    public ResponseEntity getOdontologo(@PathVariable Long id) {
        return new ResponseEntity<>(odontologoService.buscarOdontologo(id), HttpStatus.OK);
    }

    @PostMapping("/crear")
    public ResponseEntity cargarOdontologo(@RequestBody OdontologoDTO odontologoDTO) {
        odontologoService.cargarOdontologo(odontologoDTO);
        return new ResponseEntity<>("Odontologo creado con exito", HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteOdontologo(@PathVariable Long id) {
        odontologoService.eliminarOdontologo(id);
        return new ResponseEntity<>("Odontologo eliminado con exito", HttpStatus.ACCEPTED);
    }

    @PutMapping("/editar")
    public ResponseEntity editarOdontologo(@RequestBody OdontologoDTO odontologoDTO) {
        odontologoService.actualizarOdontologo(odontologoDTO);
        return new ResponseEntity<>("Odontologo actualizado con exito", HttpStatus.CREATED);
    }
}

