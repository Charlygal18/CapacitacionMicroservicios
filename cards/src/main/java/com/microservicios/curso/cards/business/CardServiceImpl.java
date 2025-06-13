package com.microservicios.curso.cards.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.microservicios.curso.cards.model.Card;
import com.microservicios.curso.cards.repository.CardRepository;
import com.microservicios.curso.cards.service.CardService;

@Service
public class CardServiceImpl implements CardService {
	
	@Autowired
	private CardRepository cardRepository;

	@Override
	public List<Card> getCardsByAccountNumber(String accountNumber) {
	
		List<Card> cards = cardRepository.findByAccountNumber(accountNumber);

		if (cards == null || cards.isEmpty()) {
		    throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Cuenta no encontrada");
		}
		    
		return cards;
	}
}
