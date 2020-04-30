package com.example.demo.impl;

import com.example.demo.model.Persona;
import com.example.demo.repository.IPersonaRepo;
import com.example.demo.service.IPersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonaServiceImpl implements IPersonaService {
    @Autowired
    public IPersonaRepo personaRepo;

    @Override
    public Persona registrar(Persona obj) {
        return personaRepo.save(obj);
    }

    @Override
    public Persona modificar(Persona obj) {
        return personaRepo.save(obj);
    }

    @Override
    public List<Persona> listar() {
        return personaRepo.findAll();
    }

    @Override
    public Persona listarPorId(Integer id) {
        Optional<Persona> op =  personaRepo.findById(id);
        return op.isPresent() ? op.get() : new Persona();
    }

    @Override
    public boolean eliminar(Integer id) {
        personaRepo.deleteById(id);
        return true;
    }
}
