package com.adriano.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.adriano.main.model.Paciente;

@Repository
public interface PacienteRepository extends JpaRepository <Paciente,Integer> {

}
