package com.microservicios.curso.cards.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "CARDS")
@IdClass(CardId.class)
public class Card {
	
	@Id
	public String accountNumber;
	@Id
	public String cardNumber;
	public String cardType;
	public String status;
	public String creationDate;

}
