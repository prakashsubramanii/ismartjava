package com.hackathon.ismart.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hackathon.ismart.model.Transaction;
import com.hackathon.ismart.model.TrasactionResponse;

@Service
public interface TransactionService {
	public TrasactionResponse makePayment(Transaction transaction);

	public TrasactionResponse receivePayment(Transaction transaction);
	
	public List<Transaction> getAllTransactions();
	
}
