package com.example.clinicaDental.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

// sacado de la documentación de Spring

@Controller
public class LoginPageController {
    @GetMapping("/login")
    public String login(){
        return "/login";
    }
}