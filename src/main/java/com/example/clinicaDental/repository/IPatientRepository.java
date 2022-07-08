package com.example.clinicaDental.repository;

import com.example.clinicaDental.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IPatientRepository extends JpaRepository<Patient, Long> {
    @Query("from Patient p where p.dni = ?1 order by p.dni")
    Optional<Patient> findByDni(String dni);
}
