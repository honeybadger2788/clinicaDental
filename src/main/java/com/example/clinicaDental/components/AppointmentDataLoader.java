package com.example.clinicaDental.components;

import com.example.clinicaDental.entity.Address;
import com.example.clinicaDental.entity.Appointment;
import com.example.clinicaDental.entity.Dentist;
import com.example.clinicaDental.entity.Patient;
import com.example.clinicaDental.repository.IAppointmentRepository;
import com.example.clinicaDental.repository.IDentistRepository;
import com.example.clinicaDental.repository.IPatientRepository;
import com.example.clinicaDental.service.IPatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class AppointmentDataLoader implements ApplicationRunner {
    @Autowired
    IAppointmentRepository appointmentRepository;

    @Autowired
    IDentistRepository dentistRepository;

    @Autowired
    IPatientRepository patientRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Address address = new Address("Elm street", 456, "CABA","CABA");
        Patient patient = new Patient("Simpson","Marge","22222222","marge@gmail.com",address);
        patientRepository.save(patient);
        Dentist dentist = new Dentist("000000","Nick","Riviera");
        dentistRepository.save(dentist);
        appointmentRepository.save(new Appointment("15-07-2022","14:00", patient, dentist));
    }
}
