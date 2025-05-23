package com.microservicios.curso.proyecto2.view;

//Paquete view para desacoplar los modelos que van a persistir en BD de lo que vamos a regresar en nuestra API como respuesta

//DTO Data Transfer Object
public class CustomerDto {
	
	private String name;
	private String lastName;
	private String email;
	
	public CustomerDto(String name, String lastName, String email) {
		super();
		this.name = name;
		this.lastName = lastName;
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	

}
