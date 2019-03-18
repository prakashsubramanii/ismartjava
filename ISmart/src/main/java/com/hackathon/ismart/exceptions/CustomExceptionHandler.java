package com.hackathon.ismart.exceptions;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;


@ControllerAdvice
public class CustomExceptionHandler{

  @ExceptionHandler(CustomerNotFoundException.class)
  public final ResponseEntity<ExceptionResponse> handleUserNotFoundException
  (CustomerNotFoundException ex, WebRequest request) {
	  
	  ExceptionResponse errorDetails = new ExceptionResponse(new Date(), request.getDescription(false),ex.getMessage());
    return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    
  }
  
  @ExceptionHandler(InsufficientFundsException.class)
  public final ResponseEntity<ExceptionResponse> handleUserConflictException
  (InsufficientFundsException ex, WebRequest request) {
	  
	  ExceptionResponse errorDetails = new ExceptionResponse(new Date(), ex.getMessage(),
        request.getDescription(false));
    return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    
  }
  
  @ExceptionHandler(MethodArgumentNotValidException.class)
  public final ResponseEntity<ExceptionResponse> handleMethodArgumentNotValidException
  (MethodArgumentNotValidException ex, WebRequest request) {
	  
	  ExceptionResponse errorDetails = new ExceptionResponse(new Date(), ex.getMessage(),
        request.getDescription(false));
    return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
    
  }
  
  @ExceptionHandler(Exception.class)
  public final ResponseEntity<ExceptionResponse> DefaultException
  (Exception ex, WebRequest request) {
	  
	  ExceptionResponse errorDetails = new ExceptionResponse(new Date(), ex.getMessage(),
        request.getDescription(false));
    return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    
  }
  
}
