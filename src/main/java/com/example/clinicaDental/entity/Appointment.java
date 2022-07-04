package com.example.clinicaDental.entity;

import javax.persistence.*;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@Entity
@Table(name="appointments")
public class Appointment {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String dateAppointment;

    private String timeAppointment;

    // el FetchType.LAZY viene por defecto, podriamos obviarlo
    @ManyToOne
    // el en caso de tener una base de datos existente, debemos ingresar el name que figura en la misma
    @JoinColumn(name = "idPatient", nullable = false)
    private Patient patient;
    @ManyToOne
    @JoinColumn(name = "idDentist", nullable = false)
    private Dentist dentist;

    public Appointment() {
    }

    public Appointment(String dateAppointment, String timeAppointment, Patient patient, Dentist dentist) {
        this.dateAppointment = dateAppointment;
        this.timeAppointment = timeAppointment;
        this.patient = patient;
        this.dentist = dentist;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDateAppointment() {
        return dateAppointment;
    }

    public void setDateAppointment(String dateAppointment) {
        this.dateAppointment = dateAppointment;
    }

    public String getTimeAppointment() {
        return timeAppointment;
    }

    public void setTimeAppointment(LocalTime timeAppointment) {
        DateTimeFormatter myFormatTime = DateTimeFormatter.ofPattern("HH:mm");
        this.timeAppointment = timeAppointment.format(myFormatTime);
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Dentist getDentist() {
        return dentist;
    }

    public void setDentist(Dentist dentist) {
        this.dentist = dentist;
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "id=" + id +
                ", dateAppointment='" + dateAppointment + '\'' +
                ", timeAppointment='" + timeAppointment + '\'' +
                ", patient=" + patient +
                ", dentist=" + dentist +
                '}';
    }
}
