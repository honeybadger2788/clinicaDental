package com.example.clinicaDental.components;

import com.example.clinicaDental.entity.Dentist;
import com.example.clinicaDental.repository.IDentistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DentistDataLoader implements ApplicationRunner {
    @Autowired
    IDentistRepository dentistRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        dentistRepository.save(new Dentist("11111111","Julius","Hibbert"));
    }
}
