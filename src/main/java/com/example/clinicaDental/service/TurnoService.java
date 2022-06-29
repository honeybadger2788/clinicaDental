package com.example.clinicaDental.service;

import com.example.clinicaDental.entity.Turno;
import com.example.clinicaDental.repository.IDao;
import com.example.clinicaDental.repository.impl.TurnoDao;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TurnoService {
    private IDao<Turno> turnoDao = new TurnoDao();

    public TurnoService() {
    }

    public TurnoService(IDao<Turno> turnoDao) {
        this.turnoDao = turnoDao;
    }

    public void setTurnoDao( IDao<Turno> turnoDao) {
        this.turnoDao = turnoDao;
    }

    public List<Turno> listarTurnos(){
        return turnoDao.buscarTodos();
    }

    public Turno buscarTurno(Long id) {
        return turnoDao.buscar(id);
    }

    public void eliminarTurno(Long id){
        turnoDao.eliminar(id);
    }

    public Turno cargarTurno(Turno turno){
        return turnoDao.cargar(turno);
    }
}
