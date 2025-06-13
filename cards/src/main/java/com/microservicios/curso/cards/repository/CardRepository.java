package com.microservicios.curso.cards.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microservicios.curso.cards.model.Card;
import com.microservicios.curso.cards.model.CardId;

public interface CardRepository extends JpaRepository<Card, CardId> {
	
	List<Card> findByAccountNumber(String accountNumber);

}
