package com.example.clinicaDental.repository.impl;

import com.example.clinicaDental.entity.Turno;
import com.example.clinicaDental.repository.IDao;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TurnoDao implements IDao<Turno> {
    private final List<Turno> turnos = new ArrayList<>();

    public TurnoDao() {
    }

    @Override
    public Turno cargar(Turno turno){
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
