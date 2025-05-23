package com.microservicios.curso.proyecto2.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.microservicios.curso.proyecto2.model.Customer;
import com.microservicios.curso.proyecto2.repository.CustomerRepository;
import com.microservicios.curso.proyecto2.service.ICustomerService;
import com.microservicios.curso.proyecto2.view.CustomerDto;
import com.microservicios.curso.proyecto2.view.SessionRequestDto;

@RestController
@RequestMapping("/api")
public class CustomerController {
	
	@Autowired
	private ICustomerService iCustomerService;
	
	@GetMapping("/customers")
	public List<CustomerDto> getCustomers(){
		
		return iCustomerService.getCustomers();		
	}
	
	@GetMapping("/customers/{customerNumber}")
	public CustomerDto getCustomer(@PathVariable("customerNumber") String customerNumber) throws Exception {
		
		return iCustomerService.getCustomer(customerNumber);
	}
	
	@PostMapping("/modificar-session/{customerNumber}")
	public ResponseEntity<String> modificarSession(@PathVariable("customerNumber") String customerNumber, @RequestBody SessionRequestDto requestSession) {
		
		 try {
			 
			 String token = iCustomerService.modificarSession(customerNumber, requestSession.getName(), requestSession.getPassword());
			 
		        return ResponseEntity.ok()
		                .header("Authorization", token)
		                .body("Sesión iniciada correctamente");
		        
	        } catch (Exception e) {
	            return ResponseEntity.badRequest().body(e.getMessage());
	        }
	}
	

}
