package com.example.clinicaDental.service;

import com.example.clinicaDental.model.Paciente;
import com.example.clinicaDental.model.Turno;
import com.example.clinicaDental.repository.IDao;
import com.example.clinicaDental.repository.IDaoTurno;
import com.example.clinicaDental.repository.impl.TurnoDao;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Service
public class TurnoService {
    private IDaoTurno<Turno> turnoDao = new TurnoDao();

    public TurnoService() {
    }

    public TurnoService(IDaoTurno<Turno> turnoDao) {
        this.turnoDao = turnoDao;
    }

    public void setTurnoDao( IDaoTurno<Turno> turnoDao) {
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

    public Turno cargarTurno(Long id, LocalDate fechaTurno, LocalTime horaTurno, Long idP, Long idO){
        return turnoDao.cargar(id, fechaTurno, horaTurno, idP, idO);
    }
}
