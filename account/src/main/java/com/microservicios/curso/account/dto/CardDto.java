package com.microservicios.curso.account.dto;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class CardDto {
	
	public String customerNumber;
	public String accountNumber;
	public int productNumber;
	public String productName;
	public String status;
	public BigDecimal balance;
	
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
