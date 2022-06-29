package com.example.clinicaDental.service;
import com.example.clinicaDental.repository.IDao;
import com.example.clinicaDental.entity.Odontologo;
import com.example.clinicaDental.repository.impl.OdontologoDao;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OdontologoService {
    private static IDao<Odontologo> odontologoDao = new OdontologoDao();

    public OdontologoService() {
    }

    public OdontologoService(IDao<Odontologo> odontologoDao) {
        this.odontologoDao = odontologoDao;
    }

    public void setOdontologoDao( IDao<Odontologo> odontologoDao) {
        this.odontologoDao = odontologoDao;
    }

    public List<Odontologo> listarOdontologos(){
        return odontologoDao.buscarTodos();
    }

    public static Odontologo buscarOdontologo(Long id) {
        return odontologoDao.buscar(id);
    }

    public void eliminarOdontologo(Long id){
        odontologoDao.eliminar(id);
    }

    public Odontologo cargarOdontologo(Odontologo odontologo){
        return odontologoDao.cargar(odontologo);
    }
}
