package com.example.demo.impl;

import com.example.demo.model.Venta;
import com.example.demo.repository.IVentaRepo;
import com.example.demo.service.IVentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VentaServiceImpl implements IVentaService {
    @Autowired
    public IVentaRepo repository;

    @Override
    public Venta registrar(Venta obj) {
        return repository.save(obj);
    }

    @Override
    public Venta modificar(Venta obj) {
        return repository.save(obj);
    }

    @Override
    public List<Venta> listar() {
        return repository.findAll();
    }

    @Override
    public Venta listarPorId(Integer id) {
        Optional<Venta> op = repository.findById(id);
        return op.isPresent() ? op.get() : new Venta();
    }

    @Override
    public boolean eliminar(Integer id) {
        repository.deleteById(id);
        return true;
    }
}
