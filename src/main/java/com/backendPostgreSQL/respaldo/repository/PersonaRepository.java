package com.backendPostgreSQL.respaldo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backendPostgreSQL.respaldo.modelo.Persona;

public interface PersonaRepository extends JpaRepository<Persona, Long>{
    Optional<Persona> findByUserId(String userId);
}
