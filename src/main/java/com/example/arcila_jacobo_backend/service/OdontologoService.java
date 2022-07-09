package com.example.arcila_jacobo_backend.service;

import com.example.arcila_jacobo_backend.modelo.Odontologo;
import com.example.arcila_jacobo_backend.repository.IOdontologoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class OdontologoService implements IOdontologoService{

    @Autowired
    private IOdontologoRepository odontologoRepository;

    @Autowired
    ObjectMapper mapper;

    private Odontologo guardarOdontologo(Odontologo Odontologo) {
        Odontologo odontologo = mapper.convertValue(Odontologo, Odontologo.class);
        return odontologoRepository.save(odontologo);
    }

    @Override
    public Odontologo crearOdontologo(Odontologo Odontologo) {
        return guardarOdontologo(Odontologo);
    }

    @Override
    public Odontologo leerOdontologo(Long id) {
        Optional<Odontologo> odontologo = odontologoRepository.findById(id);
        Odontologo Odontologo = null;
        if(odontologo.isPresent())
            Odontologo = mapper.convertValue(odontologo, Odontologo.class);
        return Odontologo;
    }

    @Override
    public Odontologo modificarOdontologo(Odontologo Odontologo) {
        return guardarOdontologo(Odontologo);
    }

    @Override
    public void eliminarOdontologo(Long id) {
        odontologoRepository.deleteById(id);
    }

    @Override
    public Set<Odontologo> getTodos() {
        List<Odontologo> odontologos = odontologoRepository.findAll();
        Set<Odontologo> odontologoDTO = new HashSet<>();
        for(Odontologo odontologo: odontologos) {
            odontologoDTO.add(mapper.convertValue(odontologo, Odontologo.class));
        }
        return odontologoDTO;
    }
}
