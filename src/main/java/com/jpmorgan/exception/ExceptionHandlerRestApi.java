package com.jpmorgan.exception;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ExceptionHandlerRestApi {

	private final static Logger logger = Logger.getLogger(ExceptionHandlerRestApi.class);
	
	@ResponseStatus(value=HttpStatus.EXPECTATION_FAILED ,  code = HttpStatus.EXPECTATION_FAILED )
	@ExceptionHandler(BusinessException.class)
	public ResponseEntity<String> businessException(BusinessException ex){
		logger.warn( ex.getMessage() );
		
		return new ResponseEntity<String>( ex.getMessage(), HttpStatus.EXPECTATION_FAILED ); 
	}

	@ResponseStatus(value=HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> exception(Exception ex){
		
		logger.error( ex.getMessage() );
		
		return new ResponseEntity<String>( "Ops.. So Sorry bu something went wrong, please try again!" , HttpStatus.EXPECTATION_FAILED );
	}

}
