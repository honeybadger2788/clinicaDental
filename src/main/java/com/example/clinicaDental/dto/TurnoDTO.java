package com.example.clinicaDental.dto;

import com.example.clinicaDental.entity.Odontologo;
import com.example.clinicaDental.entity.Paciente;

import java.time.LocalDate;
import java.time.LocalTime;

public class TurnoDTO {
    private LocalDate fechaTurno;
    private LocalTime horaTurno;
    private Paciente paciente;
    private Odontologo odontologo;

    public LocalDate getFechaTurno() {
        return fechaTurno;
    }

    public void setFechaTurno(LocalDate fechaTurno) {
        this.fechaTurno = fechaTurno;
    }

    public LocalTime getHoraTurno() {
        return horaTurno;
    }

    public void setHoraTurno(LocalTime horaTurno) {
        this.horaTurno = horaTurno;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Odontologo getOdontologo() {
        return odontologo;
    }

    public void setOdontologo(Odontologo odontologo) {
        this.odontologo = odontologo;
    }
}
