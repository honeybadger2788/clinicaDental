package com.example.clinicaDental.components;

import com.example.clinicaDental.entity.Address;
import com.example.clinicaDental.entity.Patient;
import com.example.clinicaDental.repository.IPatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class PatientDataLoader implements ApplicationRunner {

    @Autowired
    IPatientRepository patientRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Address address = new Address("Calle Falsa", 123, "CABA","CABA");
        patientRepository.save(new Patient("Simpson", "Homero","11111111","homero@gmail.com",address));
    }
}
