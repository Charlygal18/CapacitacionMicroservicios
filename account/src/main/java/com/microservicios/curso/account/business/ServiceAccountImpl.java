package com.microservicios.curso.account.business;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import com.microservicios.curso.account.dto.CardDto;
import com.microservicios.curso.account.model.Account;
import com.microservicios.curso.account.model.AccountId;
import com.microservicios.curso.account.repository.AccountRepository;
import com.microservicios.curso.account.service.AccountService;

@Service
public class ServiceAccountImpl implements AccountService {
	
	@Autowired
	private AccountRepository accountRepository;

	private final static String STATUS = "ACT";
	
	@Override
	public List<Account> getAccounts() {
		
		List<Account> accounts = accountRepository.findAll();
		
		return accounts.stream()
				.filter(account -> account.getStatus().equals(STATUS))
				.collect(Collectors.toList());
		
	}

	@Override
	public Account getAccount(AccountId accountId) {
		
		return accountRepository.findById(accountId).orElseThrow();
	}

	@Override
	public List<Account> getAccountByCustomerNumber(String customerNumber) throws Exception {
		
		return accountRepository.findByCustomerNumber(customerNumber)
				.filter(list -> !list.isEmpty())
		        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Customer not found"));
		
	}

	@Override
	public List<CardDto> getCardsByCustomerNumber(String customerNumber) throws Exception {
	    List<Account> accounts = accountRepository.findByCustomerNumber(customerNumber)
	            .filter(list -> !list.isEmpty())
	            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Customer not found"));

	    List<CardDto> cards = accounts.stream()
	        .map(card -> new CardDto(
	        		card.getCustomerNumber(),
	        		card.getAccountNumber(),
	        		card.getProductNumber(),
	        		card.getProductName(),
	        		card.getStatus(),
	        		card.getBalance()))
	        .collect(Collectors.toList());

	    return cards;
	}

}
