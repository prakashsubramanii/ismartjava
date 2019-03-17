package com.hackathon.ismart.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hackathon.ismart.exceptions.TransactionFailureException;
import com.hackathon.ismart.model.Customer;
import com.hackathon.ismart.model.Transaction;
import com.hackathon.ismart.model.TrasactionResponse;
import com.hackathon.ismart.service.CustomerService;
import com.hackathon.ismart.service.TransactionService;

@Controller
@RequestMapping("/api/customers")
@CrossOrigin
public class CustomerController {
	
	@Autowired
	CustomerService customerService;

	@Autowired
	TransactionService transactionService;
	
	@GetMapping
	public ResponseEntity<List<Customer>> getAllCustomers(){
		return new ResponseEntity<List<Customer>>(customerService.getCustomers(),HttpStatus.OK);
	}

	@GetMapping("/spendCategory")
	public ResponseEntity<List<String>> getSpendCategories(){
		List<String> spendCategory = new ArrayList<>();
		spendCategory.add("Medical");
		spendCategory.add("Travel");
		spendCategory.add("Loans");
		spendCategory.add("Utility Bills");
		spendCategory.add("Education");
		spendCategory.add("Shopping");
		spendCategory.add("Misc");
		return new ResponseEntity<List<String>>(spendCategory,HttpStatus.OK);
	}
	
	@PostMapping("/payments")
	public ResponseEntity<TrasactionResponse> makePayment( @RequestBody Transaction payment) {
		TrasactionResponse trasactionResponse = null;
		if(payment.getPaymentType().equalsIgnoreCase("credit"))
			trasactionResponse = transactionService.receivePayment(payment);
		else
			trasactionResponse = transactionService.makePayment(payment);
		if(trasactionResponse == null)
			throw new TransactionFailureException("Could Not Complete Transaction");
		return new ResponseEntity(trasactionResponse,HttpStatus.CREATED);
		
		 
	}

}
