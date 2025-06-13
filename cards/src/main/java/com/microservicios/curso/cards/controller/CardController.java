package com.microservicios.curso.cards.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservicios.curso.cards.model.Card;
import com.microservicios.curso.cards.service.CardService;

@RestController
@RequestMapping("/api")
public class CardController {
	
	@Autowired
	private CardService cardService;
	
	@GetMapping("/cards/{accountNumber}")
	public List<Card> getCards(@PathVariable("accountNumber") String accountNumber){
		
		return cardService.getCardsByAccountNumber(accountNumber);
	}

}
