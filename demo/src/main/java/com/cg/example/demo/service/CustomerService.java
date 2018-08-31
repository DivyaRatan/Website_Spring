package com.cg.example.demo.service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.cg.example.demo.dao.CustomerDao;
import com.cg.example.demo.pojo.Customer;


@Component
public class CustomerService implements CustomerServiceInterface{
	@Autowired
	private CustomerDao dao;

	@Override
	public void addCustomer(Customer customer) {
		dao.save(customer);

	}

	public List<Customer> viewAllCustomers() {
		return dao.findAll();
	}

	@Override
	public void updateCustomer(Customer customer) {
		dao.save(customer);
		
	}

	@Override
	public void deleteCustomer(int customerId) {
		dao.deleteByCustomerId(customerId);
		
	}

	@Override
	public Optional<Customer> viewCustomer(int customerId) {
		System.out.println("Customer");
		return dao.findByCustomerId(customerId);
	}


}
