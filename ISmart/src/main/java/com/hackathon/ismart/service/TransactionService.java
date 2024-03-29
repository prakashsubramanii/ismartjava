package com.hackathon.ismart.service;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.hackathon.ismart.model.Transaction;
import com.hackathon.ismart.model.TrasactionResponse;

@Service
public interface TransactionService {
	public TrasactionResponse makePayment(Transaction transaction);

	public TrasactionResponse receivePayment(Transaction transaction);
	
	public List<Transaction> getAllTransactions(Long customerid);

	public List<Transaction> getCurrentTransactions(Long customerid);

	public List<Transaction> getPeriodicTransactions(Long customerId, Date startDate, Date endDate);
	
}
