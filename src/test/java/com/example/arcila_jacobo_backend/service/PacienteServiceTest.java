package com.example.arcila_jacobo_backend.service;

import static org.junit.jupiter.api.Assertions.*;

import com.example.arcila_jacobo_backend.modelo.Odontologo;
import com.example.arcila_jacobo_backend.modelo.Paciente;
import com.example.arcila_jacobo_backend.service.IPacienteService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collection;
import java.util.Date;

@SpringBootTest
class PacienteServiceTest {

    @Autowired
    private PacienteService pacienteService;
    private Paciente paciente;

    @BeforeEach
    public void setUp() {
        paciente = new Paciente();
        paciente.setNombre("Pepe");
        paciente.setApellido("Pepardo");
        paciente.setDni("123456789");
        paciente.setDomicilio("argentina");
    }

    @Test
    public void testCrearPaciente() {
        Paciente paciente1 = pacienteService.crearPaciente(paciente);
        assertTrue(paciente1 != null);
    }

    @Test
    public void testLeerPaciente() {
        Paciente paciente1 = pacienteService.crearPaciente(paciente);
        Paciente pacientePrueba = pacienteService.leerPaciente(paciente1.getId());

        assertTrue(pacientePrueba != null);
    }

    @Test
    public void testEliminarPaciente() {
        Paciente paciente1 = pacienteService.crearPaciente(paciente);
        pacienteService.eliminarPaciente(paciente1.getId());
        assertTrue(pacienteService.leerPaciente(paciente1.getId()) == null);
    }

    @Test
    public void testModificarPaciente() {
        Paciente paciente1 = pacienteService.crearPaciente(paciente);
        Paciente original = pacienteService.leerPaciente(paciente1.getId());
        paciente.setNombre("JacoboModificado");
        paciente.setApellido("ApellidoModificado");
        Paciente modificado = pacienteService.modificarPaciente(paciente);
        assertNotEquals(modificado, original);
    }


    @Test
    public void testTodosPacientes() {
        Paciente paciente1 = pacienteService.crearPaciente(paciente);
        Collection<Paciente> pacientes = pacienteService.getTodos();

        assertTrue(!pacientes.isEmpty());
    }
}