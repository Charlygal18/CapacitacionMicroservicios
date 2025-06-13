package com.microservicios.curso.account.model;

import lombok.Data;

@Data
public class Card {
	
	public String accountNumber;
	public String cardNumber;
	public String cardType;
	public String status;
	public String creationDate;

}
