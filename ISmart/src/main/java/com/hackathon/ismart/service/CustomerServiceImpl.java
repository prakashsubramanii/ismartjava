package com.hackathon.ismart.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hackathon.ismart.model.Customer;
import com.hackathon.ismart.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	CustomerRepository customerRepo;

	@Override
	public List<Customer> getCustomers() {
		return customerRepo.findAll();
	}

}
