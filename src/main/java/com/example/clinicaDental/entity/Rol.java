package com.example.clinicaDental.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Rol {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String description;

    @OneToMany(mappedBy ="rol", cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Rol> rol = new HashSet<>();

    public Rol() {
    }

    public Rol(String description) {
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
