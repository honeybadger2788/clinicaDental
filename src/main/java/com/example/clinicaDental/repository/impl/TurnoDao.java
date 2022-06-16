package com.example.clinicaDental.repository.impl;

import com.example.clinicaDental.model.Odontologo;
import com.example.clinicaDental.model.Paciente;
import com.example.clinicaDental.model.Turno;
import com.example.clinicaDental.repository.IDaoTurno;
import com.example.clinicaDental.service.OdontologoService;
import com.example.clinicaDental.service.PacienteService;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class TurnoDao implements IDaoTurno<Turno> {
    private final List<Turno> turnos = new ArrayList<>();

    public TurnoDao() {
    }

    @Override
    public Turno cargar(Long id, LocalDate fechaTurno, LocalTime horaTurno, Long idP, Long idO){
        Paciente paciente = PacienteService.buscarPaciente(idP);
        Odontologo odontologo = OdontologoService.buscarOdontologo(idO);
        Turno turno = new Turno(id, fechaTurno, horaTurno, paciente, odontologo);
        turnos.add(turno);
        return turno;
    }

    @Override
    public void eliminar(Long id) {
        turnos.removeIf(turno -> turno.getId().equals(id));
    }

    @Override
    public Turno buscar(Long id) {
        Turno t1 = null;
        for (Turno turno: turnos
        ) {
            if (turno.getId().equals(id)) {
                t1 = turno;
            }
        }
        return t1;
    }

    @Override
    public List<Turno> buscarTodos() {
        return turnos;
    }
}
