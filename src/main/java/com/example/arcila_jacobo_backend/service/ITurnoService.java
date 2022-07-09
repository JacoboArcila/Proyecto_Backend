package com.example.arcila_jacobo_backend.service;

import com.example.arcila_jacobo_backend.modelo.Turno;

import java.util.Set;

public interface ITurnoService {
    Turno crearTurno(Turno turno);
    Turno leerTurno(Long id);
    Turno modificarTurno(Turno turno);
    void eliminarTurno(Long id);
    Set<Turno> getTodos();
}
