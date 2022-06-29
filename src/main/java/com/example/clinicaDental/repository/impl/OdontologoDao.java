package com.example.clinicaDental.repository.impl;

import com.example.clinicaDental.repository.IDao;
import com.example.clinicaDental.entity.Odontologo;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class OdontologoDao implements IDao<Odontologo> {
    private List<Odontologo> odontologos = new ArrayList<>();

    public OdontologoDao() {
    }

    @Override
    public Odontologo cargar(Odontologo odontologo){
        odontologos.add(odontologo);
        return odontologo;
    }

    @Override
    public void eliminar(Long id) {
        for (Odontologo odontologo: odontologos
        ) {
            odontologos.removeIf(paceinte -> odontologo.getId() == id);
        }
    }

    @Override
    public Odontologo buscar(Long id) {
        Odontologo o1 = null;
        for (Odontologo odontologo: odontologos
        ) {
            if (odontologo.getId() == id) {
                o1 = odontologo;
            }
        }
        return o1;
    }

    @Override
    public List<Odontologo> buscarTodos() {
        return odontologos;
    }
}
