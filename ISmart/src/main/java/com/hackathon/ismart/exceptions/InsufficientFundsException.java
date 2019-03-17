package com.hackathon.ismart.exceptions;

public class InsufficientFundsException extends RuntimeException{
	
	public InsufficientFundsException() {
		super();
	}
	
	public InsufficientFundsException(String msg) {
		super(msg);
	}

}
