package com.example.arcila_jacobo_backend.controller;

import com.example.arcila_jacobo_backend.modelo.Odontologo;
import com.example.arcila_jacobo_backend.service.IOdontologoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/odontologos")
public class OdontologoController {
    @Autowired
    IOdontologoService odontologoService;

    @PostMapping
    public ResponseEntity<?> crearOdontologo(@RequestBody Odontologo odontologo) {
        odontologoService.crearOdontologo(odontologo);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public Odontologo getOdontologo(@PathVariable Long id) {
        return odontologoService.leerOdontologo(id);
    }

    @PutMapping
    public ResponseEntity<?> modificarOdontologo(@RequestBody Odontologo odontologo ) {
        odontologoService.modificarOdontologo(odontologo);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarOdontologo(@PathVariable Long id) {
        odontologoService.eliminarOdontologo(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping
    public Collection<Odontologo> getTodosOdontologos() {
        return odontologoService.getTodos();
    }
}
