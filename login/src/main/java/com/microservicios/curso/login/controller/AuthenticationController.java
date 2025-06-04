package com.microservicios.curso.login.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservicios.curso.login.model.Customer;
import com.microservicios.curso.login.service.AuthenticationService;
import com.microservicios.curso.login.view.Credentials;

@RestController
@RequestMapping("/api")
public class AuthenticationController {
	
	@Autowired
	private AuthenticationService authenticationService;
	
	@PostMapping("/login")
	public ResponseEntity<String> login(@RequestBody Credentials credentials) throws Exception {
		
		Customer customer = authenticationService.getCustomer(credentials.getCustomerNumber());
		
		if (customer == null || !authenticationService.Authenticate(customer, credentials)) {
			return new ResponseEntity<>("Credenciales inválidas", HttpStatus.UNAUTHORIZED);
		}
		
		if(authenticationService.usuarioBloqueado(customer)) {
			
			return new ResponseEntity<>("Usuario bloqueado", HttpStatus.FORBIDDEN);
		}
		
		if(authenticationService.sesionIniciada(customer)) {
			
			return new ResponseEntity<>("El usuario ya tiene una sesión activa", HttpStatus.CONFLICT);
		}
		
		return new ResponseEntity<>("Login exitoso", HttpStatus.OK);
	}
	

	

}
