package com.microservicios.curso.login.service;

import com.microservicios.curso.login.model.Customer;
import com.microservicios.curso.login.view.Credentials;


public interface AuthenticationService {
	
	public Customer getCustomer(String customerNumber) throws Exception;
	
	public boolean Authenticate(Customer customer, Credentials credentials) throws Exception;
	
	public boolean usuarioBloqueado(Customer customer) throws Exception;
	
	public boolean sesionIniciada(Customer customer) throws Exception;

}
