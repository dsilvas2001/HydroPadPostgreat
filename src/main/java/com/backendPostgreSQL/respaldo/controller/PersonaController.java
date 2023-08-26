package com.backendPostgreSQL.respaldo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backendPostgreSQL.respaldo.modelo.Persona;
import com.backendPostgreSQL.respaldo.services.PersonaServices;


@RestController
@RequestMapping(value= "/userHydropad")
public class PersonaController {
	@Autowired
	private final PersonaServices personaService;
	
	@Autowired
    public PersonaController(PersonaServices personaService) {
        this.personaService = personaService;
    }

	@GetMapping(value = "/mostrar")
    public List<Persona> findAllEmployee() {
        return personaService.findAllPersona();
    }

    @GetMapping (value = "/{id}")
    public Optional<Persona> findEmployeeById(@PathVariable("id") Long id) {
        return personaService.findById(id);
    }

    @PostMapping (value = "/add")
    public Persona saveEmployee(@RequestBody Persona personamodel) {
        return personaService.savePersona(personamodel);
    }

//    @PutMapping (value = "/{id}/update")
//    public Persona updateEmployee(@RequestBody Persona personamodel) {
//        return personaService.updatePersona(personamodel);
//    }
    
    @PutMapping (value = "/{id}/update")
    public Persona updateEmployee(@PathVariable("id") Long id, @RequestBody Persona personamodel) {
        return personaService.updatePersona(id, personamodel);
    }

    
    @DeleteMapping (value = "/{id}/delete")
    public void deleteEmployee(@PathVariable("id") Long id) {
    	personaService.deletePersona(id);
    }
}
