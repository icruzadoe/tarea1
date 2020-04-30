package com.example.demo.impl;

import com.example.demo.model.DetalleVenta;
import com.example.demo.repository.IDetalleVentaRepo;
import com.example.demo.service.IDetalleVentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DetalleVentaServiceImpl  implements IDetalleVentaService {
    @Autowired
    public IDetalleVentaRepo repository;

    @Override
    public DetalleVenta registrar(DetalleVenta obj) {
        return repository.save(obj);
    }

    @Override
    public DetalleVenta modificar(DetalleVenta obj) {
        return repository.save(obj);
    }

    @Override
    public List<DetalleVenta> listar() {
        return repository.findAll();
    }

    @Override
    public DetalleVenta listarPorId(Integer id) {
        Optional<DetalleVenta> op = repository.findById(id);
        return op.isPresent() ? op.get() : new DetalleVenta();
    }

    @Override
    public boolean eliminar(Integer id) {
        repository.deleteById(id);
        return true;
    }
}
