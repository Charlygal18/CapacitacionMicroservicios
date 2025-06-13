package com.microservicios.curso.login.util;

import java.util.UUID;

public class Util {

	public static String createToken() {
		
		return UUID.randomUUID().toString();
				
	}
	
}
