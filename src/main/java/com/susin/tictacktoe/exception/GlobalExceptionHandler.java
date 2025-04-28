package com.susin.tictacktoe.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(TickTackToeException.class)
	public ResponseEntity<String> handleCustomException(TickTackToeException e){
		return new ResponseEntity <>(e.getMessage(),HttpStatus.BAD_REQUEST);
		
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> handleException(Exception e){
		return new ResponseEntity <>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
}
