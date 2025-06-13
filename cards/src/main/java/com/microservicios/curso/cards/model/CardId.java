package com.microservicios.curso.cards.model;

import java.io.Serializable;

import lombok.Data;

@Data
public class CardId implements Serializable {
	
	public String accountNumber;
	public String cardNumber;

}
