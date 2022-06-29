package com.example.clinicaDental.repository.impl;

import com.example.clinicaDental.repository.IDao;
import com.example.clinicaDental.entity.Paciente;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PacienteDao implements IDao<Paciente> {
    private List<Paciente> pacientes = new ArrayList<>();

    public PacienteDao() {
    }

    @Override
    public Paciente cargar(Paciente paciente){
        pacientes.add(paciente);
        return paciente;
    }

    @Override
    public void eliminar(Long id) {
        for (Paciente paciente: pacientes
             ) {
            pacientes.removeIf(paceinte -> paciente.getId() == id);
        }
    }

    @Override
    public Paciente buscar(Long id) {
        Paciente p1 = null;
        for (Paciente paciente: pacientes
        ) {
            if (paciente.getId() == id) {
                p1 = paciente;
            }
        }
        return p1;
    }

    @Override
    public List<Paciente> buscarTodos() {
        return pacientes;
    }
}
