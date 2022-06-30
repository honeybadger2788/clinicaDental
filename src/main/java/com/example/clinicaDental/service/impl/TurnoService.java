package com.example.clinicaDental.service.impl;

import com.example.clinicaDental.dto.TurnoDTO;
import com.example.clinicaDental.entity.Turno;
import com.example.clinicaDental.repository.ITurnoRepository;
import com.example.clinicaDental.service.ITurnoService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TurnoService implements ITurnoService {

    @Autowired
    ITurnoRepository turnoRepository;

    @Autowired
    ObjectMapper mapper;


    @Override
    public Collection<TurnoDTO> listarTurnos() {
        Set<TurnoDTO> turnosDTO = new HashSet<>();
        List<Turno> turnos = turnoRepository.findAll();
        for (Turno turno :
                turnos) {
            turnosDTO.add(mapper.convertValue(turno, TurnoDTO.class));
        }
        return turnosDTO;
    }

    @Override
    public TurnoDTO buscarTurno(Long id) {
        TurnoDTO turnoDTO = null;
        Optional<Turno> turno = turnoRepository.findById(id);
        if (turno.isPresent()) {
            turnoDTO = mapper.convertValue(turno, TurnoDTO.class);
        }
        return turnoDTO;
    }

    @Override
    public void eliminarTurno(Long id) {
        turnoRepository.deleteById(id);
    }

    @Override
    public void cargarTurno(TurnoDTO turnoDTO) {
        Turno turno = mapper.convertValue(turnoDTO, Turno.class);
        turnoRepository.save(turno);
    }
}
