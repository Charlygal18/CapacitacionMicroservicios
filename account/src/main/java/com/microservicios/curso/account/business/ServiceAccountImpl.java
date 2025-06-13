package com.microservicios.curso.account.business;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservicios.curso.account.client.CardsClient;
import com.microservicios.curso.account.dto.AccountDto;
import com.microservicios.curso.account.exception.ForbiddenException;
import com.microservicios.curso.account.model.Account;
import com.microservicios.curso.account.model.AccountId;
import com.microservicios.curso.account.repository.AccountRepository;
import com.microservicios.curso.account.service.AccountService;

@Service
public class ServiceAccountImpl implements AccountService {
	
	@Autowired
	private AccountRepository accountRepository;

	@Autowired
	private CardsClient cardsClient;
	
	private final static String STATUS = "ACT";
	
	private Function<Account, AccountDto> accountMapper = account -> new AccountDto(account.getAccountNumber(), 
			account.getProductNumber(), account.getProductName(), account.getBalance(), cardsClient.getCards(account.getAccountNumber()));
	
	@Override
	public List<Account> getAccounts() {
		
		List<Account> accounts = accountRepository.findAll();
		
		return accounts.stream()
				.filter(account -> account.getStatus().equals(STATUS))
				.collect(Collectors.toList());
		
	}

	@Override
	public Account getAccount(AccountId accountId) {
		
		return accountRepository.findById(accountId)
				.orElseThrow(() -> new ForbiddenException("You are no authorized"));
	}

	@Override
	public List<Account> getAccountByCustomerNumber(String customerNumber) throws Exception {
		
		List<Account> cuentas = accountRepository.findByCustomerNumber(customerNumber)
				.orElseThrow(() -> new ForbiddenException("You are no authorized"));
		
		return cuentas;
		
	}

	@Override
	public List<AccountDto> getCustomerAccounts(String customerNumber) {


		List<Account> accounts = accountRepository.findByCustomerNumber(customerNumber)
				.orElseThrow(() -> new ForbiddenException("You are no authorized"));;
		
		return accounts.stream().map(accountMapper)
				.collect(Collectors.toList());
	}

}
