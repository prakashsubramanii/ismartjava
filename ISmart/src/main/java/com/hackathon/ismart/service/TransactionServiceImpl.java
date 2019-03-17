package com.hackathon.ismart.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hackathon.ismart.exceptions.InsufficientFundsException;
import com.hackathon.ismart.model.Transaction;
import com.hackathon.ismart.model.TrasactionResponse;
import com.hackathon.ismart.repository.TransactionRepository;

@Service
public class TransactionServiceImpl implements TransactionService {

	@Autowired
	private TransactionRepository transactionRepository;

	@Autowired
	private CustomerServiceImpl customerService;

	@Override
	public TrasactionResponse makePayment(Transaction transaction) {
		Long custId = transaction.getCustomerId();
		Double bal = customerService.getBalance(custId);
		if (transaction.getAmount() > bal) {
			throw new InsufficientFundsException("Insufficient Funds");
		}
		Double updatedBalance = bal - transaction.getAmount();
		customerService.updateBalance(custId, updatedBalance);
		transaction.setBalance(updatedBalance);
		Transaction savedTransaction = transactionRepository.save(transaction);
		TrasactionResponse trasactionResponse = new TrasactionResponse();
		trasactionResponse.setTrasactionId(savedTransaction.getTransactionId());
		return trasactionResponse;

	}

	@Override
	public TrasactionResponse receivePayment(Transaction transaction) {
		Long custId = transaction.getCustomerId();
		Double bal = customerService.getBalance(custId);
		Double updatedBalance = bal + transaction.getAmount();
		customerService.updateBalance(custId, updatedBalance);
		transaction.setBalance(updatedBalance);
		Transaction savedTransaction = transactionRepository.save(transaction);
		TrasactionResponse trasactionResponse = new TrasactionResponse();
		trasactionResponse.setTrasactionId(savedTransaction.getTransactionId());
		return trasactionResponse;

	}

	@Override
	public List<Transaction> getAllTransactions(Long customerid) {
		return transactionRepository.findByCustomerId(customerid);
	}

	@Override
	public List<Transaction> getCurrentTransactions(Long customerid) {
		return transactionRepository.findCurrentTransactions(customerid);
	}
}
