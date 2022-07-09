package com.example.arcila_jacobo_backend.service;

import com.example.arcila_jacobo_backend.modelo.Turno;
import com.example.arcila_jacobo_backend.repository.ITurnoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class TurnoService implements ITurnoService {

    @Autowired
    private ITurnoRepository turnoRepository;

    @Autowired
    ObjectMapper mapper;

    private Turno guardarTurno(Turno turno) {
        Turno turnos = mapper.convertValue(turno, Turno.class);
         return turnoRepository.save(turnos);
    }

    @Override
    public Turno crearTurno(Turno turno) {
         return guardarTurno(turno);
    }

    @Override
    public Turno leerTurno(Long id) {
        Optional<Turno> turnos = turnoRepository.findById(id);
        Turno turno = null;
        if(turnos.isPresent())
            turno = mapper.convertValue(turnos, Turno.class);
        return turno;
    }

    @Override
    public Turno modificarTurno(Turno turno) {
        return guardarTurno(turno);
    }

    @Override
    public void eliminarTurno(Long id) {
        turnoRepository.deleteById(id);
    }

    @Override
    public Set<Turno> getTodos() {
        List<Turno> turnos = turnoRepository.findAll();
        Set<Turno> turnoDTO = new HashSet<>();
        for(Turno turno: turnos) {
            turnoDTO.add(mapper.convertValue(turno, Turno.class));
        }
        return turnoDTO;
    }
}
