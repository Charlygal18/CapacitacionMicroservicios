package com.microservicios.curso.account.dto;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class CardDto {
	
	private String customerNumber;
	private String accountNumber;
	private int productNumber;
	private String productName;
	private String status;
	private BigDecimal balance;
	
	public CardDto(String customerNumber, String accountNumber, int productNumber, String productName, String status,
			BigDecimal balance) {
		super();
		this.customerNumber = customerNumber;
		this.accountNumber = accountNumber;
		this.productNumber = productNumber;
		this.productName = productName;
		this.status = status;
		this.balance = balance;
	}
	
	

}
