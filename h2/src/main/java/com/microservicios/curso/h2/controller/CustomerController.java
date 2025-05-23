package com.microservicios.curso.h2.controller;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.microservicios.curso.h2.model.Customer;
import com.microservicios.curso.h2.repository.CustomerRepository;

@RestController
@RequestMapping("/api")
public class CustomerController {
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@GetMapping("/customers")
	public List<Customer> getCustomers(){
		
		return customerRepository.findAll();		
	}
	
	@GetMapping("/customers/{customerNumber}")
	public Customer getCustomer(@PathVariable("customerNumber") String customerNumber) throws Exception {
		
		return customerRepository.findById(customerNumber)
				.orElseThrow(() -> new Exception("Customer not found"));
	}
	
	@GetMapping("/customersByStatus")
	public List<Customer> getByStatus(@RequestParam String status){
		
		return customerRepository.findByStatus(status);
	}
	
}
