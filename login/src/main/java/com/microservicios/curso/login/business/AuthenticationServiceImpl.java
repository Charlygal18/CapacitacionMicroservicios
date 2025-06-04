package com.microservicios.curso.login.business;

import java.util.Objects;
import java.util.function.BiPredicate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservicios.curso.login.model.Customer;
import com.microservicios.curso.login.repository.CustomerRepository;
import com.microservicios.curso.login.service.AuthenticationService;
import com.microservicios.curso.login.view.Credentials;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

	@Autowired
	private CustomerRepository customerRepository;
	
	BiPredicate<Customer, Credentials> customerValidation = 
			(customer, credentials) ->  Objects.isNull(customer) 
			|| !customer.getCustomerNumber().equals(credentials.getCustomerNumber())
			|| !customer.getPassword().equals(credentials.getPassword());
	
	@Override
	public boolean Authenticate(Customer customer, Credentials credentials) throws Exception {
		
		if(customerValidation.test(customer, credentials)) {
			return false;
		}
		
		return true;
	}

	@Override
	public boolean usuarioBloqueado(Customer customer) throws Exception {
		
		if(!customer.getStatus().equals("B")) {
			return false;
		}
		
		return true;
		}

	@Override
	public boolean sesionIniciada(Customer customer) throws Exception {
		
		if(!customer.isSessionAlive()) {
			return false;
		}
		return true;
	}

	@Override
	public Customer getCustomer(String customerNumber) throws Exception {
		
		return customerRepository.findById(customerNumber).orElse(null);
	}

}
