package com.microservicios.curso.proyecto2.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "CUSTOMERS")
public class Customer {
	
	@Id
	@Column(name = "CUSTOMER_NUMBER")
	private String customerNumber;
	
	@Column(name = "PASSWORD")
	private String password;
	
	@Column(name = "EMAIL")
	private String email;
	
	@Column(name = "STATUS")
	private String status;
	
	@Column(name = "CREATION")
	private String creation;
	
	@Column(name = "NAME")
	private String name;
	
	@Column(name = "LAST_NAME")
	private String lastName;
	
	@Column(name = "SESSION")
	private boolean isSessionAlive;

	public String getCustomerNumber() {
		return customerNumber;
	}

	public void setCustomerNumber(String customerNumber) {
		this.customerNumber = customerNumber;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCreation() {
		return creation;
	}

	public void setCreation(String creation) {
		this.creation = creation;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public boolean isSessionAlive() {
		return isSessionAlive;
	}

	public void setSessionAlive(boolean isSessionAlive) {
		this.isSessionAlive = isSessionAlive;
	}

	@Override
	public String toString() {
		return "Customer [customerNumber=" + customerNumber + ", password=" + password + ", email=" + email
				+ ", status=" + status + ", creation=" + creation + ", name=" + name + ", lastName=" + lastName
				+ ", isSessionAlive=" + isSessionAlive + "]";
	}

}
