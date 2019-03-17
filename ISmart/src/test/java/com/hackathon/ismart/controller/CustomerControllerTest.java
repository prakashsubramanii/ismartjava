package com.hackathon.ismart.controller;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.hackathon.ismart.model.Customer;
import com.hackathon.ismart.repository.CustomerRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerControllerTest {

	@Autowired
	CustomerController customerController;

	@Mock
	CustomerRepository customerRepo;

	@Test
	public void getCustomerTest() {

		List<Customer> customerResList = new ArrayList<>();
		List<Customer> customerList = new ArrayList<>();
		Customer customer = new Customer();
		customer.setCustomerId(new Long(111));
		customer.setBalance(10000);
		customerList.add(customer);
		customer.setCustomerId(new Long(222));
		customer.setBalance(20000);
		customerList.add(customer);

		when(customerRepo.findAll()).thenReturn(customerList);

		customerResList = customerController.getAllCustomers().getBody();
		customerResList.stream().forEach(c -> System.out.println("Customer :: " + c.toString()));
		assertNotNull(customerResList);

	}

}
