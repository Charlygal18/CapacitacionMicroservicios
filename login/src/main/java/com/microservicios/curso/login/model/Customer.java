package com.microservicios.curso.login.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

// Equivalent to @Getter @Setter @RequiredArgsConstructor @ToString @EqualsAndHashCode
@Data
@Entity
@Table(name="CUSTOMERS")
public class Customer {
	
	@Id
	@Column(name="CUSTOMER_NUMBER")
	private String customerNumber;
	
	private String password;
	
	@Column(name="SESSION")
	private boolean isSessionAlive;
	
	private String status;

}
