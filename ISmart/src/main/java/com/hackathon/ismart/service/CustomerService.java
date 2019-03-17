package com.hackathon.ismart.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hackathon.ismart.model.Customer;

@Service
public interface CustomerService {

	List<Customer> getCustomers();

}
