package com.microservicios.curso.login.controller;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservicios.curso.login.model.Customer;
import com.microservicios.curso.login.service.AuthenticationService;
import com.microservicios.curso.login.service.SessionManagement;
import com.microservicios.curso.login.view.Credentials;

import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/api")
public class AuthenticationController {
	
	@Autowired
	private AuthenticationService authenticationService;
	
	@Autowired 
	private SessionManagement sessionManagement;
	
	@PostMapping("/login")
	public ResponseEntity<HttpStatus> login(HttpServletResponse response, 
			@RequestBody Credentials credentials) {
		
		return ResponseEntity.ok()
				.header("Authorization", authenticationService.Authenticate(credentials)).build();
	}
	
	@DeleteMapping("/close-session")
	public ResponseEntity<HttpStatus> closeSession(@RequestHeader("Authorization") String token){
		
		if(Objects.isNull(token) || token.isEmpty()) {
			
			return ResponseEntity.notFound().build();
		}
		
		Boolean terminaSession = sessionManagement.terminateSession(token);
		
		if(terminaSession) {
			
			return ResponseEntity.ok().build();
		}
		else {
			
			return ResponseEntity.notFound().build();
		}
		
	}

}
