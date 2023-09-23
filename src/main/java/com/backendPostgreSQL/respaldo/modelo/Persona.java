package com.backendPostgreSQL.respaldo.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "UserHydropad")
public class Persona {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Otra estrategia según tus necesidades
	private Long id;

	@Column(name = "email_user", length = 40, nullable = false)
	private String email;

	@Column(name = "name_user", length = 50, nullable = false)
	private String nombre;
	@Column(name = "uid_user", length = 40, nullable = false)
	private String userId;
	
	public Persona() {
        // Deja el cuerpo vacío o inicializa valores predeterminados si es necesario
    }

	public Persona(String email, String nombre, String userId) {
		super();
		this.email = email;
		this.nombre = nombre;
		this.userId = userId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	
}
