package com.microservicios.curso.account.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservicios.curso.account.dto.CardDto;
import com.microservicios.curso.account.model.Account;
import com.microservicios.curso.account.service.AccountService;

@RestController
@RequestMapping("/api")
public class AccountController {
	
	@Autowired
	private AccountService accountService;
	
	@GetMapping("/accounts/{customerNumber}")
	public List<Account> accountsRetrieve(@PathVariable("customerNumber") String customerNumber) throws Exception{
		
		return accountService.getAccountByCustomerNumber(customerNumber);
		
	}
	
	@GetMapping("/cards/{customerNumber}")
	public List<CardDto> getCards(@PathVariable("customerNumber") String customerNumber) throws Exception{
		
		return accountService.getCardsByCustomerNumber(customerNumber);
	}

}
