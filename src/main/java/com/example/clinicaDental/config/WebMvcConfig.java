package com.example.clinicaDental.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/home").setViewName("index");
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/pacientes").setViewName("listPatients");
        registry.addViewController("/pacientes/crear").setViewName("formPatient");
        registry.addViewController("/odontologos").setViewName("listDentists");
        registry.addViewController("/odontologos/crear").setViewName("formDentist");
        registry.addViewController("/turnos").setViewName("listAppointments");
        registry.addViewController("/turnos/crear").setViewName("formAppointment");

    }

}