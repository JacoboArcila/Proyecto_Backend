package com.example.arcila_jacobo_backend.service;

import com.example.arcila_jacobo_backend.modelo.Odontologo;

import java.util.Set;

public interface IOdontologoService {
    Odontologo crearOdontologo(Odontologo Odontologo);
    Odontologo leerOdontologo(Long id);
    Odontologo modificarOdontologo(Odontologo Odontologo);
    void eliminarOdontologo(Long id);
    Set<Odontologo> getTodos();
}
