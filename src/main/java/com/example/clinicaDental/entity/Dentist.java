package com.example.clinicaDental.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="dentists")
public class Dentist {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String licence;
    private String firstName;
    private String lastName;

    @OneToMany(mappedBy = "dentist", cascade = CascadeType.ALL)
    private Set<Appointment> appointments = new HashSet<>();

    public Dentist() {
    }

    public Dentist(String licence, String firstName, String lastName) {
        this.licence = licence;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Long getId() {
        return id;
    }

    public String getLicence() {
        return licence;
    }

    public void setLicence(String licence) {
        this.licence = licence;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Dentist{" +
                "id=" + id +
                ", licence='" + licence + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
