package com.talcorpdz.api.internal.rest;

 

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.talcorpdz.api.internal.exception.IllegalGenericCrudArgumentsException;

@ControllerAdvice
public class GenericRestAdviceController extends ResponseEntityExceptionHandler   {
	
	@ExceptionHandler(IllegalGenericCrudArgumentsException.class)
	public ResponseEntity<Object> handleCityNotFoundException(
			IllegalGenericCrudArgumentsException ex, WebRequest request) {
	    return new ResponseEntity<>(ex.getBody(), HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
