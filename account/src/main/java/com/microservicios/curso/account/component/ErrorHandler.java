package com.microservicios.curso.account.component;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.microservicios.curso.account.exception.ErrorResponse;
import com.microservicios.curso.account.exception.ForbiddenException;
import com.microservicios.curso.account.exception.UnauthorizedException;
import com.microservicios.curso.account.model.ErrorType;

import jakarta.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class ErrorHandler {

	@ExceptionHandler(UnauthorizedException.class)
	@ResponseStatus(HttpStatus.UNAUTHORIZED)
	public ErrorResponse handlerUnauthorizedException(HttpServletRequest req, UnauthorizedException ex) {
		
		ErrorResponse errorResponse = new ErrorResponse();
		
		errorResponse.setCode(HttpStatus.UNAUTHORIZED.value());
		errorResponse.setMessage(ex.getMessage());
		errorResponse.setLocation(req.getRequestURI());
		errorResponse.setType(ErrorType.ERROR);
		
		System.out.println(errorResponse);
		
		return errorResponse;
	}
	
	@ExceptionHandler(ForbiddenException.class)
	@ResponseStatus(HttpStatus.FORBIDDEN)
	public ErrorResponse handlerForbiddenException(HttpServletRequest req, ForbiddenException ex) {
		
		ErrorResponse errorResponse = new ErrorResponse();
		
		errorResponse.setCode(HttpStatus.FORBIDDEN.value());
		errorResponse.setMessage(ex.getMessage());
		errorResponse.setLocation(req.getRequestURI());
		errorResponse.setType(ErrorType.ERROR);
		
		System.out.println(errorResponse);
		
		return errorResponse;
	}

}
