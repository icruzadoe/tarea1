package com.example.demo.controller;

import com.example.demo.model.Persona;
import com.example.demo.service.IPersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/personas")
public class PersonaController {
    @Autowired
    private IPersonaService personaService;

    @GetMapping
    public ResponseEntity<List<Persona>> listar (){
        List<Persona> personas = personaService.listar();
        return new ResponseEntity<List<Persona>>(personas,HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Object> registrar(@RequestBody Persona persona){
        Persona nuevaPersona = personaService.registrar(persona);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(nuevaPersona.getIdPersona()).toUri();
        return ResponseEntity.created(location).build();
    }

}
