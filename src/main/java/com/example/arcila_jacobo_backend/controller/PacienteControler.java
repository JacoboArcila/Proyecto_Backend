package com.example.arcila_jacobo_backend.controller;

import com.example.arcila_jacobo_backend.modelo.Paciente;
import com.example.arcila_jacobo_backend.service.IPacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/pacientes")
public class PacienteControler {

    @Autowired
    IPacienteService pacienteService;

    @PostMapping
    public ResponseEntity<?> crearPaciente(@RequestBody Paciente paciente) {
        pacienteService.crearPaciente(paciente);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public Paciente getPaciente(@PathVariable Long id) {
        return pacienteService.leerPaciente(id);
    }

    @PutMapping
    public ResponseEntity<?> modificarPaciente(@RequestBody Paciente paciente ) {
        pacienteService.modificarPaciente(paciente);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarPaciente(@PathVariable Long id) {
        pacienteService.eliminarPaciente(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping
    public Collection<Paciente> getTodosPacientes() {
        return pacienteService.getTodos();
    }
}
