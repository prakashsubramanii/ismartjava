package com.hackathon.ismart.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.hackathon.ismart.exceptions.InsufficientFundsException;
import com.hackathon.ismart.model.Transaction;
import com.hackathon.ismart.model.TrasactionResponse;
import com.hackathon.ismart.repository.TransactionRepository;

public class TransactionServiceImpl implements TransactionService {
	
	@Autowired	
	private  TransactionRepository transactionRepository;
	
	@Autowired
	private CustomerServiceImpl customerService;
	
	public TrasactionResponse makePayment(Transaction transaction) {
		Long custId = transaction.getCustomer().getCustomerId();
		Double bal = customerService.getBalance(custId);
		if(transaction.getAmount() > bal) {
			throw new InsufficientFundsException("Insufficient Funds");
		}
		customerService.updateBalance(custId,bal-transaction.getAmount());
		Transaction savedTransaction = transactionRepository.save(transaction);
		TrasactionResponse trasactionResponse = new TrasactionResponse();
		 trasactionResponse.setTrasactionId(savedTransaction.getTransactionId());
		 return trasactionResponse;
		
	}
	
public TrasactionResponse receivePayment(Transaction transaction) {
	Long custId = transaction.getCustomer().getCustomerId();
	Double bal = customerService.getBalance(custId);
	   customerService.updateBalance(custId,bal+transaction.getAmount());
		Transaction savedTransaction = transactionRepository.save(transaction);
		TrasactionResponse trasactionResponse = new TrasactionResponse();
		 trasactionResponse.setTrasactionId(savedTransaction.getTransactionId());
		 return trasactionResponse;
		
	}
}
