package com.example.demo.impl;

import com.example.demo.model.Producto;
import com.example.demo.repository.IProductoRepo;
import com.example.demo.service.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoServiceImpl implements IProductoService {
    @Autowired
    public IProductoRepo repository;

    @Override
    public Producto registrar(Producto obj) {
        return repository.save(obj);
    }

    @Override
    public Producto modificar(Producto obj) {
        return repository.save(obj);
    }

    @Override
    public List<Producto> listar() {
        return repository.findAll();
    }

    @Override
    public Producto listarPorId(Integer id) {
        Optional<Producto> op = repository.findById(id);
        return op.isPresent() ? op.get() : new Producto();
    }

    @Override
    public boolean eliminar(Integer id) {
        repository.deleteById(id);
        return true;
    }
}
