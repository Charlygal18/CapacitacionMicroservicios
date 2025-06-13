package com.microservicios.curso.account.exception;

public class UnauthorizedException extends RuntimeException {
	
	public UnauthorizedException() {
		
		super();
	}
	
	public UnauthorizedException(String message) {
		
		super(message);
	}

}
