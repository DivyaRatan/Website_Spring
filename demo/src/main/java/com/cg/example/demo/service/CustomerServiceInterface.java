package com.cg.example.demo.service;

import java.util.Collection;
import java.util.Optional;

import com.cg.example.demo.pojo.Customer;



public interface CustomerServiceInterface {
	void addCustomer(Customer customer);

	Collection<Customer> viewAllCustomers();

	void updateCustomer(Customer customer);

	void deleteCustomer(int customerId);

	Optional<Customer> viewCustomer(int customerId);
}
