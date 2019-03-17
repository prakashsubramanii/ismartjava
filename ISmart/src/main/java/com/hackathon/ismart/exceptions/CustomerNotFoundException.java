package com.hackathon.ismart.exceptions;

public class CustomerNotFoundException extends RuntimeException {
	
	public  CustomerNotFoundException() {
		super();
	}
	
	public  CustomerNotFoundException(String msg) {
		super(msg);
	}

}
