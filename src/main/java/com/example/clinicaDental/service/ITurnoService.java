package com.example.clinicaDental.service;

import com.example.clinicaDental.dto.TurnoDTO;
import com.example.clinicaDental.entity.Paciente;
import com.example.clinicaDental.entity.Turno;

import java.util.Collection;

public interface ITurnoService {
    public Collection<TurnoDTO> listarTurnos();

    public TurnoDTO buscarTurno(Long id);

    public void eliminarTurno(Long id);

    public void cargarTurno(TurnoDTO turnoDTO);

    public void actualizarTurno(Turno turno);
}
