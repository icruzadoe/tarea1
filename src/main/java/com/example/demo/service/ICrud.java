package com.example.demo.service;

import java.util.List;

public interface ICrud<type, value> {

    type registrar(type obj);
    type modificar(type obj);
    List<type> listar();
    type listarPorId(value id);
    boolean eliminar(value id);
}
