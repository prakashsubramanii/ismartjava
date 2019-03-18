package com.hackathon.ismart.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hackathon.ismart.exceptions.CustomerNotFoundException;
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
	
	public Double getBalance(Long customerId) {
		Customer customer = customerRepo.findById(customerId).orElseThrow(()->new CustomerNotFoundException("Customer Not Found with id:"+customerId));
		return customer.getBalance();
	}
	
	public void updateBalance(Long customerId,Double balance) {
		Customer customer = customerRepo.findById(customerId).orElseThrow(()->new CustomerNotFoundException());
		customer.setBalance(balance);
		customerRepo.save(customer);
		
	}
	
	public void update(Customer customer) {
		customerRepo.save(customer);
		
	}

}
