package com.microservicios.curso.login.business;

import java.util.Objects;
import java.util.UUID;
import java.util.function.BiPredicate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.microservicios.curso.login.exception.ForbiddenException;
import com.microservicios.curso.login.exception.UnauthorizedException;
import com.microservicios.curso.login.model.Customer;
import com.microservicios.curso.login.repository.CustomerRepository;
import com.microservicios.curso.login.service.AuthenticationService;
import com.microservicios.curso.login.service.SessionManagement;
import com.microservicios.curso.login.util.Util;
import com.microservicios.curso.login.view.Credentials;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
	
	@Autowired
	private SessionManagement sessionManagement;
	
	@Autowired
	private CustomerRepository customerRepository;
	
	private BiPredicate<Customer, Credentials> customerValidation = 
			(cu, cr) ->  Objects.nonNull(cu) && cu.getCustomerNumber().equals(cr.getCustomerNumber()) 
			&& cu.getPassword().equals(cr.getPassword());
	
	@Override
	public String Authenticate(Credentials credentials) {
		
		Customer customer = customerRepository.findById(credentials.getCustomerNumber())
				.orElseThrow(() -> new ForbiddenException("You are no authorized"));
		
		if(!customerValidation.test(customer, credentials)) {

			throw new UnauthorizedException("Customer number or password incorrect");
		}
		
		return sessionManagement.createSession(customer);
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


}
