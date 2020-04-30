package com.example.demo.repository;

import com.example.demo.model.DetalleVenta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDetalleVentaRepo extends JpaRepository<DetalleVenta, Integer> {
}
