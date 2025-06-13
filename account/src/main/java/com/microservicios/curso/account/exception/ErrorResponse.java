package com.microservicios.curso.account.exception;

import com.microservicios.curso.account.model.ErrorType;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class ErrorResponse {

	private int code;
	private ErrorType type;
	private String message;
	private String details;
	private String location;
	
	
}
