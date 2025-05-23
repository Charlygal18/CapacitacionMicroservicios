package com.microservicios.curso.proyecto2.view;

public class SessionRequestDto {
	
	private String name;
	private String password;
	
	public SessionRequestDto() {
		
	}
	
	public SessionRequestDto(String name, String password) {
		super();
		this.name = name;
		this.password = password;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	

}
