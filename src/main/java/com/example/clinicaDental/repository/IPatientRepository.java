package com.example.clinicaDental.repository;

import com.example.clinicaDental.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface IPatientRepository extends JpaRepository<Patient, Long> {
    @Query("select p from Patient p where p.dni = dni")
    Set<Patient> getPatientByDni(String dni);
}
