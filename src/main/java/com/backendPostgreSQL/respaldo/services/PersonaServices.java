package com.backendPostgreSQL.respaldo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.backendPostgreSQL.respaldo.modelo.Persona;

@Service
public interface PersonaServices {
	List<Persona> findAllPersona();

	Optional<Persona> findById(Long id);

	Persona savePersona(Persona personaEntity);
	
    Persona updateNameByUserId(String userId, String newName);

	Persona updatePersona(Long id,Persona personaEntity);

	void deletePersona(Long id);
}
