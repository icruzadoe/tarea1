package com.example.demo.controller;

import com.example.demo.model.DetalleVenta;
import com.example.demo.service.IDetalleVentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/detalleventas")
public class DetalleVentaController {
    @Autowired
    private IDetalleVentaService serviceDetalleVenta;

    @GetMapping
    public ResponseEntity<List<DetalleVenta>> listar(){
        List<DetalleVenta> detalleVentas = serviceDetalleVenta.listar();
        return new ResponseEntity<List<DetalleVenta>>(detalleVentas, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Object> registrar(@RequestBody DetalleVenta detalleVenta){
        DetalleVenta nuevoDetalleVenta = serviceDetalleVenta.registrar(detalleVenta);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(nuevoDetalleVenta.getIdDetalleVenta()).toUri();
        return ResponseEntity.created(location).build();
    }
}
