package com.example.clinicaDental.model;

import java.time.LocalDate;
import java.time.LocalTime;

public class Turno {
    private Long id;
    private LocalDate fechaTurno;
    private LocalTime horaTurno;
    private Paciente paciente;
    private Odontologo odontologo;

    public Turno() {
    }

    public Turno(Long id, LocalDate fechaTurno, LocalTime horaTurno, Paciente paciente, Odontologo odontologo) {
        this.id = id;
        this.fechaTurno = fechaTurno;
        this.horaTurno = horaTurno;
        this.paciente = paciente;
        this.odontologo = odontologo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
