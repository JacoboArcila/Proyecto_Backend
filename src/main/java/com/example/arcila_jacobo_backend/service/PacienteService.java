package com.example.arcila_jacobo_backend.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.example.arcila_jacobo_backend.modelo.Paciente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.arcila_jacobo_backend.repository.IPacienteRepository;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;


@Service
public class PacienteService implements IPacienteService {
    @Autowired
    private IPacienteRepository pacienteRepository;

    @Autowired
    ObjectMapper mapper;

    @Override
    public Paciente crearPaciente(Paciente paciente) {
        return guardarPaciente(paciente);
    }

    @Override
    public Paciente leerPaciente(Long id) {
        Optional<Paciente> paciente = pacienteRepository.findById(id);
        Paciente pacienteDTO = null;
        if(paciente.isPresent())
            pacienteDTO = mapper.convertValue(paciente, Paciente.class);
            return pacienteDTO;
    }

    private Paciente guardarPaciente(Paciente paciente) {
        Paciente pacientes = mapper.convertValue(paciente, Paciente.class);
        return pacienteRepository.save(pacientes);
    }

    @Override
    public Paciente modificarPaciente(Paciente paciente) {
        return guardarPaciente(paciente);
    }

    @Override
    public void eliminarPaciente(Long id) {
        pacienteRepository.deleteById(id);
    }

    @Override
    public Set<Paciente> getTodos() {
        List<Paciente> pacientes = pacienteRepository.findAll();
        Set<Paciente> pacientes1 = new HashSet<>();
        for(Paciente paciente: pacientes) {
            pacientes1.add(mapper.convertValue(paciente, Paciente.class));
        }
        return pacientes1;
    }
}
