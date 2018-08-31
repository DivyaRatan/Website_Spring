package com.cg.example.demo.dao;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.cg.example.demo.pojo.Customer;
@Repository
public interface CustomerDao extends MongoRepository<Customer, String>{

	Optional<Customer> findByCustomerId(int customerId);
	void deleteByCustomerId(int customerId);
}
