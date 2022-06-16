package com.example.clinicaDental.service;

import com.example.clinicaDental.repository.IDao;
import com.example.clinicaDental.model.Paciente;
import com.example.clinicaDental.repository.impl.PacienteDao;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PacienteService {
    private static IDao<Paciente> pacienteDao = new PacienteDao();

    public PacienteService() {
    }

    public PacienteService(IDao<Paciente> pacienteDao) {
        this.pacienteDao = pacienteDao;
    }

    public void setpacienteDao( IDao<Paciente> pacienteDao) {
        this.pacienteDao = pacienteDao;
    }

    public List<Paciente> listarPacientes(){
        return pacienteDao.buscarTodos();
    }

    public static Paciente buscarPaciente(Long id) {
        return pacienteDao.buscar(id);
    }

    public void eliminarPaciente(Long id){
        pacienteDao.eliminar(id);
    }

    public Paciente cargarPaciente(Paciente paciente){
        return pacienteDao.cargar(paciente);
    }
}
