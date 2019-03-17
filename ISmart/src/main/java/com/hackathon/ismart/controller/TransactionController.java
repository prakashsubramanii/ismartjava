package com.hackathon.ismart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hackathon.ismart.model.Customer;
import com.hackathon.ismart.model.Transaction;
import com.hackathon.ismart.service.TransactionService;

@Controller
@RequestMapping("api/transactions")
@CrossOrigin
public class TransactionController {
	@Autowired
	TransactionService transactionService;
	
	@GetMapping
	public ResponseEntity<List<Transaction>> getAllTransactions(){
		return new ResponseEntity(transactionService.getAllTransactions(),HttpStatus.OK);
	}
}
