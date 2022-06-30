package com.example.clinicaDental.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="pacientes")
// @Getter @Setter para que los genere el framework automaticamente
public class Paciente {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE)
    private Long id;
    private String apellido;
    private String nombre;
    @Column(unique = true)
    private String dni;
    private String email;
    private LocalDate fechaIngreso;

    // si se elimina al paciente, se elimina también su domicilio
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idDomicilio", referencedColumnName = "id")
    private Domicilio domicilio;

    @OneToMany(mappedBy ="paciente",fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<Turno> turnos = new HashSet<>();

    public Paciente() {
    }

    public Paciente(String apellido, String nombre, String dni, String email, LocalDate fechaIngreso, Domicilio domicilio) {
        this.apellido = apellido;
        this.nombre = nombre;
        this.dni = dni;
        this.email = email;
        this.fechaIngreso = fechaIngreso;
        this.domicilio = domicilio;
    }

    public Long getId() {
        return id;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(LocalDate fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public Domicilio getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(Domicilio domicilio) {
        this.domicilio = domicilio;
    }

    @Override
    public String toString() {
        return "Paciente{" +
                "id=" + id +
                ", apellido='" + apellido + '\'' +
                ", nombre='" + nombre + '\'' +
                ", dni='" + dni + '\'' +
                ", email='" + email + '\'' +
                ", fechaIngreso='" + fechaIngreso + '\'' +
                ", domicilio=" + domicilio +
                '}';
    }
}
