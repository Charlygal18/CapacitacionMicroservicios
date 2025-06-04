package com.microservicios.curso.account.model;

import java.io.Serializable;
import lombok.Data;

@Data
public class AccountId implements Serializable {

	private String customerNumber;
	private String accountNumber;
}
