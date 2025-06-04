package com.microservicios.curso.account.service;

import java.util.List;
import com.microservicios.curso.account.dto.CardDto;
import com.microservicios.curso.account.model.Account;
import com.microservicios.curso.account.model.AccountId;

public interface AccountService {

	 List<Account> getAccounts();
	    
	 List<Account> getAccountByCustomerNumber(String customerNumber) throws Exception;
	    
     Account getAccount(AccountId accountId);
	    
     List<CardDto> getCardsByCustomerNumber(String customerNumber)  throws Exception;
	
}

