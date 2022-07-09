package com.example.arcila_jacobo_backend.controller;

import com.example.arcila_jacobo_backend.modelo.Turno;
import com.example.arcila_jacobo_backend.service.ITurnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/turnos")
public class TurnoController {

    @Autowired
    ITurnoService turnoService;

    @PostMapping
    public ResponseEntity<?> crearTurno(@RequestBody Turno turno) {
        turnoService.crearTurno(turno);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public Turno getOTurno(@PathVariable Long id) {
        return turnoService.leerTurno(id);
    }

    @PutMapping
    public ResponseEntity<?> modificarTurno(@RequestBody Turno turno ) {
        turnoService.modificarTurno(turno);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarTurno(@PathVariable Long id) {
        turnoService.eliminarTurno(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping
    public Collection<Turno> getTodosTurnos() {
        return turnoService.getTodos();
    }
}
