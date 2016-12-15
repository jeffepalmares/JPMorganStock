package com.jpmorgan.exception;

public class BusinessException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1570502043954231556L;
	
	public BusinessException(String message){
		super(message);
	}
}
