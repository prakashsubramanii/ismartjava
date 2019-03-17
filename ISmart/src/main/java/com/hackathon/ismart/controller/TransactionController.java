package com.hackathon.ismart.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hackathon.ismart.model.Transaction;
import com.hackathon.ismart.service.TransactionService;

@Controller
@RequestMapping("api/transactions")
@CrossOrigin
public class TransactionController {
	@Autowired
	TransactionService transactionService;
	
	@GetMapping("/{customerid}")
	public ResponseEntity<List<Transaction>> getAllTransactions(@PathVariable Long customerid){
		return new ResponseEntity<List<Transaction>>(transactionService.getAllTransactions(customerid),HttpStatus.OK);
	}
	
	@GetMapping("/current/{customerid}")
	public ResponseEntity<List<Transaction>> getCurrentTransactions(@PathVariable Long customerid){
		return new ResponseEntity<List<Transaction>>(transactionService.getCurrentTransactions(customerid),HttpStatus.OK);
	}
	
	@GetMapping("/periodic/{customerid}")
    public ResponseEntity<List<Transaction>> getPeriodicTransactions(@PathVariable Long customerid, @RequestParam String startDate, @RequestParam String endDate) throws ParseException{
                   return new ResponseEntity<List<Transaction>>(transactionService.getPeriodicTransactions(customerid,new SimpleDateFormat("yyyy-MM-dd").parse(startDate),new SimpleDateFormat("yyyy-MM-dd").parse(endDate)),HttpStatus.OK);
    }


}
