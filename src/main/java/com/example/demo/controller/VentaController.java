package com.example.demo.controller;

import com.example.demo.model.Venta;
import com.example.demo.service.IVentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/ventas")
public class VentaController {
    @Autowired
    private IVentaService serviceVenta;

    @GetMapping
    public ResponseEntity<List<Venta>> listar(){
        List<Venta> ventas = serviceVenta.listar();
        return new ResponseEntity<List<Venta>>(ventas, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Object> registrar(@RequestBody Venta venta){
        Venta nuevaVenta = serviceVenta.registrar(venta);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(nuevaVenta.getIdVenta()).toUri();
        return ResponseEntity.created(location).build();
    }
}
