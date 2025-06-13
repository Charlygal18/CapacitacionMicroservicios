package com.microservicios.curso.account.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservicios.curso.account.dto.AccountDto;
import com.microservicios.curso.account.dto.CardDto;
import com.microservicios.curso.account.model.Account;
import com.microservicios.curso.account.service.AccountService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {
	
	@Autowired
	private AccountService accountService;
	
	@Autowired
	private RedisTemplate<String, String> redisTemplate;

	@GetMapping("/v2/{customerNumber}")
	public ResponseEntity<?> getCardsByCustumerNumber(
	        @RequestHeader(value = "Authorization", required = false) String authorization,
	        @PathVariable("customerNumber") String customerNumber) throws Exception {

	    String storedToken = redisTemplate.opsForValue().get(customerNumber);

	    if (authorization == null || storedToken == null || !storedToken.equals(authorization)) {
	    	
	        return new ResponseEntity<>("Token incorrecto o ausente", HttpStatus.FORBIDDEN);
	    }

	    List<AccountDto> accounts = accountService.getCustomerAccounts(customerNumber);

	    return new ResponseEntity<>(accounts, HttpStatus.OK);
	}

}

