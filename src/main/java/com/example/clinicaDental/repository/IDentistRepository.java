package com.example.clinicaDental.repository;

import com.example.clinicaDental.entity.Dentist;
import com.example.clinicaDental.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface IDentistRepository extends JpaRepository<Dentist,Long> {
    @Query("from Dentist d where d.licence = ?1 order by d.licence")
    Set<Dentist> findByLicence(String licence);
}
