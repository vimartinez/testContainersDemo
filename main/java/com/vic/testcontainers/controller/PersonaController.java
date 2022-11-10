package com.vic.testcontainers.controller;

import com.vic.testcontainers.model.Persona;
import com.vic.testcontainers.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class PersonaController {

    @Autowired
    PersonaService personaService;

    @GetMapping("/personas")
    @ResponseBody
    public List<Persona> getAllPersonas(){
        return personaService.getAllPersonas();
    }
}
