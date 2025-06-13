package com.microservicios.curso.account.dto;

import java.math.BigDecimal;
import java.util.List;
import com.microservicios.curso.account.model.Card;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AccountDto {
	
	private String accountNumber;
	private int productNumber;
	private String productName;
	private BigDecimal balance;
	private List<Card> cards;

}
