package com.example.arcila_jacobo_backend.service;

import com.example.arcila_jacobo_backend.modelo.Paciente;

import java.util.Set;

public interface IPacienteService {
    Paciente crearPaciente(Paciente paciente);
    Paciente leerPaciente(Long id);
    Paciente modificarPaciente(Paciente paciente);
    void eliminarPaciente(Long id);
    Set<Paciente> getTodos();
}
