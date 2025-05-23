package com.microservicios.curso.proyecto2.business;

import java.util.List;
import java.util.UUID;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservicios.curso.proyecto2.model.Customer;
import com.microservicios.curso.proyecto2.repository.CustomerRepository;
import com.microservicios.curso.proyecto2.service.ICustomerService;
import com.microservicios.curso.proyecto2.view.CustomerDto;

@Service
public class CustomerServiceImpl implements ICustomerService {

	@Autowired CustomerRepository customerRepository;
	// Un método abstracto para solo implementarse de una manera
	private Function<Customer, CustomerDto> mapper = 
			customer -> new CustomerDto(customer.getName(), customer.getLastName(), customer.getEmail());
	
	@Override
	public List<CustomerDto> getCustomers() {
		
		return customerRepository.findAll().stream().map(mapper).collect(Collectors.toList());
	}

	@Override
	public CustomerDto getCustomer(String customerNumber) throws Exception {
		
		return mapper.apply(customerRepository.findById(customerNumber).orElseThrow(() -> new Exception("Customer not found")));
	}

	@Override
	public String modificarSession(String customerNumber, String name, String password) throws Exception {
		
		Customer customer = customerRepository.findByCustomerNumber(customerNumber)
				.orElseThrow(() -> new Exception("Cliente no encontrado"));
		
		if (!customer.getName().equals(name)) {
		    throw new Exception("El nombre ingresado no coincide");
		}

		if (!customer.getPassword().equals(password)) {
		    throw new Exception("La contraseña es incorrecta");
		}

		if (!customer.getStatus().equals("A")) {
		    throw new Exception("El usuario está bloqueado");
		}

		customer.setSessionAlive(true);
		customerRepository.save(customer);
		
		return UUID.randomUUID().toString();

	}

}
