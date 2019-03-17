package com.hackathon.ismart.exceptions;

public class TransactionFailureException extends RuntimeException{

	public TransactionFailureException() {
		super();
	}
	
	public TransactionFailureException(String msg) {
		super(msg);
	}
}
