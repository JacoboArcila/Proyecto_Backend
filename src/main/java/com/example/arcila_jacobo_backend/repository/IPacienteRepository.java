package com.example.arcila_jacobo_backend.repository;

import com.example.arcila_jacobo_backend.modelo.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPacienteRepository extends JpaRepository<Paciente, Long> {

}
