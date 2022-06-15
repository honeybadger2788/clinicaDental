package com.example.clinicaDental.repository.impl;

import com.example.clinicaDental.repository.IDao;
import com.example.clinicaDental.model.Turno;

import java.util.ArrayList;
import java.util.List;

public class TurnoDao implements IDao<Turno> {
    private List<Turno> turnos = new ArrayList<>();

    public TurnoDao() {
    }

    @Override
    public Turno cargar(Turno turno){
        turnos.add(turno);
        return turno;
    }

    @Override
    public void eliminar(Long id) {
        turnos.removeIf(turno -> turno.getId() == id);
    }

    @Override
    public Turno buscar(Long id) {
        Turno t1 = null;
        for (Turno turno: turnos
        ) {
            if (turno.getId() == id) {
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
