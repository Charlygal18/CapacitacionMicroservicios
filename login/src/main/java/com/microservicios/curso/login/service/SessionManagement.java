package com.microservicios.curso.login.service;

import com.microservicios.curso.login.model.Customer;

public interface SessionManagement {

	String createSession(Customer customer);
	
	Boolean terminateSession(String token);
	
}
