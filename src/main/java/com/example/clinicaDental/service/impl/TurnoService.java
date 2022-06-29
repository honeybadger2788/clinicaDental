package com.example.clinicaDental.service.impl;

import com.example.clinicaDental.dto.TurnoDTO;
import com.example.clinicaDental.entity.Turno;
import com.example.clinicaDental.repository.IDao;
import com.example.clinicaDental.repository.IPacienteRepository;
import com.example.clinicaDental.service.ITurnoService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class TurnoService implements ITurnoService {

    @Autowired
    IPacienteRepository pacienteRepository;

    @Autowired
    ObjectMapper mapper;


    @Override
    public Collection<TurnoDTO> listarTurnos() {
        return null;
    }

    @Override
    public TurnoDTO buscarTurno(Long id) {
        return null;
    }

    @Override
    public void eliminarTurno(Long id) {

    }

    @Override
    public void cargarTurno(TurnoDTO turnoDTO) {
    }
}
