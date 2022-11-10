package com.vic.testcontainers.service;

import com.vic.testcontainers.model.Persona;
import com.vic.testcontainers.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonaService {

    @Autowired
    PersonaRepository personaRepository;

    public List<Persona> getAllPersonas(){
        return personaRepository.findAll();
    }
}
