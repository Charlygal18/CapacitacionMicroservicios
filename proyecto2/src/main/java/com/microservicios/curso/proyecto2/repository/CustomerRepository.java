package com.microservicios.curso.proyecto2.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.microservicios.curso.proyecto2.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, String> {
	
	Optional<Customer> findByCustomerNumber(String customerNumber);


}
