package com.microservicios.curso.cards.service;

import java.util.List;

import com.microservicios.curso.cards.model.Card;

public interface CardService {

	List<Card> getCardsByAccountNumber(String accountNumber);
	
}
