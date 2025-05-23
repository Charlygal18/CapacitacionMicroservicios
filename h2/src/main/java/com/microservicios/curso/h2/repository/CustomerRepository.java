package com.microservicios.curso.h2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microservicios.curso.h2.model.Customer;

// Interfaz genérica que recibe la entidad y la primaryKey
public interface CustomerRepository extends JpaRepository<Customer, String> {
	
	List<Customer> findByStatus(String status);

}
