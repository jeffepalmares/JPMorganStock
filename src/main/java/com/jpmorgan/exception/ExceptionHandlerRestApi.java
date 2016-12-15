package com.jpmorgan.exception;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ExceptionHandlerRestApi {

	private final static Logger logger = Logger.getLogger(ExceptionHandlerRestApi.class);
	
	@ResponseStatus(value=HttpStatus.EXPECTATION_FAILED ,  code = HttpStatus.EXPECTATION_FAILED )
	@ExceptionHandler(BusinessException.class)
	public String businessException(BusinessException ex){
		logger.warn( ex.getMessage() );
		return ex.getMessage();
	}

	@ResponseStatus(value=HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(Exception.class)
	public String exception(Exception ex){
		logger.error( ex.getMessage() );
		return "Ops.. So Sorry bu something went wrong, please try again!";
	}

}
