package com.microservicios.curso.login.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microservicios.curso.login.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, String> {

}
