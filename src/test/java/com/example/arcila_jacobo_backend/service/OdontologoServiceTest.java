package com.example.arcila_jacobo_backend.service;

import com.example.arcila_jacobo_backend.modelo.Odontologo;
import com.example.arcila_jacobo_backend.modelo.Paciente;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collection;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class OdontologoServiceTest {
    @Autowired
    private IOdontologoService odontologoService;
    private Odontologo odontologo;

    @BeforeEach
    public void setUp() {
        odontologo = new Odontologo();
        odontologo.setNombre("Pepe");
        odontologo.setApellido("Pepardo");
        odontologo.setMatricula(123456789);
    }

    @Test
    public void testCrearOdontologo() {
        Odontologo odontologo1 = odontologoService.crearOdontologo(odontologo);

        assertTrue(odontologo1 != null);
    }

    @Test
    public void testLeerOdontologo() {
        Odontologo odontologo1 = odontologoService.crearOdontologo(odontologo);
        Odontologo odontologoJacobo = odontologoService.leerOdontologo(odontologo1.getId());

        assertTrue(odontologoJacobo != null);
    }

    @Test
    public void testEliminarOdontologo() {
        Odontologo odontologo1 = odontologoService.crearOdontologo(odontologo);
        odontologoService.eliminarOdontologo(odontologo1.getId());
        assertTrue(odontologoService.leerOdontologo(odontologo1.getId()) == null);
    }

    @Test
    public void testModificarOdontologo() {
        Odontologo odontologo1 = odontologoService.crearOdontologo(odontologo);
        Odontologo original = odontologoService.leerOdontologo(odontologo1.getId());
        odontologo.setNombre("JacoboModificado");
        odontologo.setApellido("ApellidoModificado");
        Odontologo modificado = odontologoService.modificarOdontologo(odontologo);
        assertNotEquals(modificado, original);
    }


    @Test
    public void testTodosOdontologo() {
        Odontologo odontologo1 = odontologoService.crearOdontologo(odontologo);
        Collection<Odontologo> odontologos = odontologoService.getTodos();

        assertTrue(!odontologos.isEmpty());
    }

}