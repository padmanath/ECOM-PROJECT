package com.te.ecombasepack.applicationValidationExceptionHandler;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AppValidationExceptionHandler {

@ResponseStatus(HttpStatus.BAD_REQUEST)
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	
	public Map<String, String> handleInvalidArugument(MethodArgumentNotValidException exception) {
		
		 Map<String, String> errorMap=new HashMap<>();
		 
		 exception.getBindingResult().getFieldErrors().forEach(error -> {                                   ///getField in list to select....only u can use for each loop
			 
			 errorMap.put(error.getField(), error.getDefaultMessage());
			 
		 });                          
		 
		 return errorMap;
	}
	
	
	
}
