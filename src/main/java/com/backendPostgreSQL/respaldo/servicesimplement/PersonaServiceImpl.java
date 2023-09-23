package com.backendPostgreSQL.respaldo.servicesimplement;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backendPostgreSQL.respaldo.modelo.Persona;
import com.backendPostgreSQL.respaldo.repository.PersonaRepository;
import com.backendPostgreSQL.respaldo.services.PersonaServices;

import jakarta.persistence.EntityNotFoundException;

@Service
public class PersonaServiceImpl implements PersonaServices {

	private final PersonaRepository personaRepository;

    @Autowired
    public PersonaServiceImpl(PersonaRepository personaRepository) {
        this.personaRepository = personaRepository;
    }
    
    

	@Override
	public List<Persona> findAllPersona() {
		// TODO Auto-generated method stub
		return personaRepository.findAll();
	}

	@Override
	public Optional<Persona> findById(Long id) {
		// TODO Auto-generated method stub
		return personaRepository.findById(id);
	}

	@Override
	public Persona savePersona(Persona personaEntity) {
		// TODO Auto-generated method stub
		return personaRepository.save(personaEntity);
	}

//	@Override
//	public Persona updatePersona(String id,Persona personaEntity) {
//		// TODO Auto-generated method stub
//		return personaRepository.save(personaEntity);
//	}
	
	
	@Override
	public Persona updatePersona(Long id, Persona personaEntity) {
	    Optional<Persona> existingPersona = personaRepository.findById(id);
	    if (existingPersona.isPresent()) {
	        Persona updatedPersona = existingPersona.get();
	        updatedPersona.setEmail(personaEntity.getEmail());
	        updatedPersona.setNombre(personaEntity.getNombre());
	        updatedPersona.setUserId(personaEntity.getUserId());
	        
	        return personaRepository.save(updatedPersona);
	    } else {
	        throw new EntityNotFoundException("Persona with ID " + id + " not found");
	    }
	}
	
	
	@Override
    public Persona updateNameByUserId(String userId, String newName) {
        Optional<Persona> existingPersona = personaRepository.findByUserId(userId);
        if (existingPersona.isPresent()) {
            Persona persona = existingPersona.get();
            persona.setNombre(newName);
            return personaRepository.save(persona);
        } else {
            throw new EntityNotFoundException("Persona with userId " + userId + " not found");
        }
    }
	
	
	
	

	@Override
	public void deletePersona(Long id) {
		// TODO Auto-generated method stub
		personaRepository.deleteById(id);
	}

}
