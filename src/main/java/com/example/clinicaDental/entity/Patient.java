package com.example.clinicaDental.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="patients")
// @Getter @Setter para que los genere el framework automaticamente
public class Patient {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private String lastName;

    private String firstName;
    @Column(unique = true)

    private String dni;

    private String email;

    // la fecha de ingreso se guardará por defecto con la fecha de creación del paciente
    private LocalDate admissionDate;

    //al poner el cascade si se elimina al paciente, se elimina también su domicilio
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idAddress", referencedColumnName = "id")
    private Address address;

    @OneToMany(mappedBy ="patient", cascade = CascadeType.ALL)
    @JsonIgnore // para evitar un bucle infinito por usar el mapper y al tratarse de una relacion bidireccional
    private Set<Appointment> appointments = new HashSet<>();

    public Patient() {
    }

    public Patient(String lastName, String firstName, String dni, String email, Address address) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.dni = dni;
        this.email = email;
        this.admissionDate = LocalDate.now();
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
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

    public void setAdmissionDate(LocalDate admissionDate) {
        if(admissionDate == null)
            this.admissionDate = LocalDate.now();
        else
            this.admissionDate = admissionDate;
    }

    public LocalDate getAdmissionDate() {
        return admissionDate;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "id=" + id +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", dni='" + dni + '\'' +
                ", email='" + email + '\'' +
                ", admissionDate=" + admissionDate +
                ", address=" + address +
                '}';
    }
}
