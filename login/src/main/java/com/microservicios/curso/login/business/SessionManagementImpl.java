package com.microservicios.curso.login.business;

import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.microservicios.curso.login.exception.ForbiddenException;
import com.microservicios.curso.login.model.Customer;
import com.microservicios.curso.login.repository.CustomerRepository;
import com.microservicios.curso.login.service.SessionManagement;
import com.microservicios.curso.login.util.Util;


@Service
public class SessionManagementImpl implements SessionManagement {
	
	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private RedisTemplate<String, String> redisTemplate;

	@Override
	public String createSession(Customer customer) {
		
		validaCustomerBlocked(customer);
		checkSessionAlive(customer);
		
		String token = Util.createToken();
		redisTemplate.opsForValue().set(token, customer.getCustomerNumber(), 600, TimeUnit.SECONDS);
		customer.setSessionAlive(true);
		customerRepository.save(customer);
		
		return token;
	}
	
	@Override
	public Boolean terminateSession(String token) {
		
		String customerNumber = redisTemplate.opsForValue().get(token);
		
		if(Objects.isNull(customerNumber) || customerNumber.isEmpty()) {
			
			return false;
		}
		
		Customer customer = customerRepository.findById(customerNumber)
				.orElseThrow(() -> new ForbiddenException("You are no authorized"));
		
		customer.setSessionAlive(false);
		customerRepository.save(customer);
		redisTemplate.delete(token);
		
		return true;
		
	}
	
	private void validaCustomerBlocked(Customer customer) {
		
		if(customer.getStatus().equals("B")) {
			
			throw new ForbiddenException("Your customer is blocked");
		}
	}
	
	private void checkSessionAlive(Customer customer) {
		
		if(customer.isSessionAlive()) {
			
			throw new ForbiddenException("You have an active session");
		}
	}
	
}
