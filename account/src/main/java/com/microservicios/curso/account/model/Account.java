package com.microservicios.curso.account.model;

import java.math.BigDecimal;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.microservicios.curso.account.dto.CardDto;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import lombok.Data;

// BigDecimal para monedas en Java
@Data
@Entity
@Table(name = "ACCOUNTS")
// Llave primaria compuesta se debe crear una clase que contenga los dos campos
@IdClass(AccountId.class)
public class Account {

	@Id
	private String customerNumber;
	@Id
	private String accountNumber;
	private int productNumber;
	private String productName;
	private String status;
	private BigDecimal balance;
	private String creationDate;

	//private List<CardDto> cards;
}
