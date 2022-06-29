package com.example.clinicaDental.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name="turnos")
public class Turno {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE)
    private Long id;
    @Column
    private LocalDate fechaTurno;
    @Column
    private LocalTime horaTurno;

    // el FetchType.LAZY viene por defecto, podriamos obviarlo
    @ManyToOne(fetch = FetchType.LAZY)
    // el en caso de tener una base de datos existente, debemos ingresar el name que figura en la misma
    @JoinColumn(name = "idPaciente", nullable = false)
    private Paciente paciente;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idOdontologo", nullable = false)
    private Odontologo odontologo;

    public Turno() {
    }

    public Turno(LocalDate fechaTurno, LocalTime horaTurno, Paciente paciente, Odontologo odontologo) {
        this.fechaTurno = fechaTurno;
        this.horaTurno = horaTurno;
        this.paciente = paciente;
        this.odontologo = odontologo;
    }

    public Long getId() {
        return id;
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

    @Override
    public String toString() {
        return "Turno{" +
                "id=" + id +
                ", fechaTurno=" + fechaTurno +
                ", horaTurno=" + horaTurno +
                ", paciente=" + paciente +
                ", odontologo=" + odontologo +
                '}';
    }
}
