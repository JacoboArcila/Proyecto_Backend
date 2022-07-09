package com.example.arcila_jacobo_backend.service;

import com.example.arcila_jacobo_backend.modelo.Odontologo;
import com.example.arcila_jacobo_backend.modelo.Paciente;
import com.example.arcila_jacobo_backend.modelo.Turno;
import com.example.arcila_jacobo_backend.service.IOdontologoService;
import com.example.arcila_jacobo_backend.service.IPacienteService;
import com.example.arcila_jacobo_backend.service.ITurnoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TurnoServiceTest {
    @Autowired
    private IPacienteService pacienteService;
    private Paciente paciente;

    @Autowired
    private IOdontologoService odontologoService;
    private Odontologo odontologo;

    @Autowired
    private ITurnoService turnoService;

    @BeforeEach
    public void setUp() {
        paciente = new Paciente();
        paciente.setNombre("Pepe");
        paciente.setApellido("Pepardo");
        paciente.setDni("123456789");
        paciente.setDomicilio("argentina");

        odontologo = new Odontologo();
        odontologo.setNombre("Pepo");
        odontologo.setApellido("Pepardo");
        odontologo.setMatricula(123456);
    }

    @Test
    public void testCrearTurno() {
        Paciente pacienteCreado = pacienteService.crearPaciente(paciente);
        Odontologo odontologoCreado = odontologoService.crearOdontologo(odontologo);
        Turno turno = new Turno();
        Date date = new Date();
        turno.setFecha(date);
        turno.setPaciente(pacienteCreado);
        turno.setOdontologo(odontologoCreado);
        Turno turnoCreado = turnoService.crearTurno(turno);
        assertNotNull(turnoService.leerTurno(turnoCreado.getId()));
    }

    @Test
    public void testModificarTurno() {
        Turno turno = new Turno();
        Date date = new Date();
        turno.setFecha(date);
        turno.setPaciente(pacienteService.crearPaciente(paciente));
        turno.setOdontologo(odontologoService.crearOdontologo(odontologo));
        Turno turnoCreado = turnoService.crearTurno(turno);
        turno.setFecha(date);
        Turno turnoActualizado = turnoService.modificarTurno(turno);
        assertNotEquals(turnoActualizado, turnoCreado);
    }

    /*@Test
    public void testLeerTurno() {
        Turno turno = new Turno();
        Date date = new Date();
        turno.setFecha(date);
        turno.setPaciente(pacienteService.crearPaciente(paciente));
        turno.setOdontologo(odontologoService.crearOdontologo(odontologo));
        turnoService.crearTurno(turno);
        Turno turno1 = turnoService.leerTurno(paciente.getId());
        assertTrue(turno1 != null);
    }*/

    @Test
    public void testEliminarTurno() {
        Turno turno = new Turno();
        Date date = new Date();
        turno.setFecha(date);
        turno.setPaciente(pacienteService.crearPaciente(paciente));
        turno.setOdontologo(odontologoService.crearOdontologo(odontologo));
        turnoService.crearTurno(turno);
        turnoService.eliminarTurno(1L);
        assertTrue(turnoService.leerTurno(1L) == null);
    }

    @Test
    public void testConsultarTodos() {
        Turno turno = new Turno();
        Date date = new Date();
        turno.setFecha(date);
        turno.setPaciente(pacienteService.crearPaciente(paciente));
        turno.setOdontologo(odontologoService.crearOdontologo(odontologo));
        turnoService.crearTurno(turno);
        assertNotEquals(0, turnoService.getTodos().size());
    }



}