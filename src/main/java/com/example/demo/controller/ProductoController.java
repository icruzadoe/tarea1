package com.example.demo.controller;

import com.example.demo.model.Producto;
import com.example.demo.service.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/productos")
public class ProductoController {
    @Autowired
    private IProductoService serviceProducto;

    @GetMapping
    public ResponseEntity<List<Producto>> listar(){
        List<Producto> productos = serviceProducto.listar();
        return new ResponseEntity<List<Producto>>(productos, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Object> registrar(@RequestBody Producto producto){
        Producto nuevoProducto = serviceProducto.registrar(producto);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(nuevoProducto.getIdProducto()).toUri();
        return ResponseEntity.created(location).build();
    }
}
