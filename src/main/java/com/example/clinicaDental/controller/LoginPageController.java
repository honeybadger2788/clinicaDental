package com.example.clinicaDental.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

// sacado de la documentación de Spring para renderizar el formulario de login personalizado

@Controller
public class LoginPageController {
    @GetMapping("/login")
    public String login(){
        return "/login";
    }
}