package com.microservicios.curso.proyecto2.service;

import java.util.List;
import com.microservicios.curso.proyecto2.view.CustomerDto;

public interface ICustomerService {

	List<CustomerDto> getCustomers();
	
	CustomerDto getCustomer(String customerNumber) throws Exception;
	
	String modificarSession(String customerNumber, String name, String password) throws Exception;
}
