package com.microservicios.curso.account.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.microservicios.curso.account.model.Account;
import com.microservicios.curso.account.model.AccountId;

public interface AccountRepository extends JpaRepository<Account, AccountId> {
	
	Optional<List<Account>> findByCustomerNumber(String customerNumber);

}
