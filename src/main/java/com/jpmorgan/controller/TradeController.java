package com.jpmorgan.controller;

import org.apache.log4j.Logger;

import com.jpmorgan.exception.BusinessException;
import com.jpmorgan.factory.ServiceFactory;
import com.jpmorgan.model.Stock;
import com.jpmorgan.model.Trade;
import com.jpmorgan.service.TradeService;
import com.jpmorgan.util.Validations;

public class TradeController {

	private final static Logger logger = Logger.getLogger( StockController.class );
	
	private TradeService service;
	
	public TradeController(){
		
		this.service = ServiceFactory.createTradeService();
		
	}
	
	private boolean isNotValidateInput( Stock stock,Double price, int quantity ){
		
		if( price == null || price < 0 || Validations.isNotValidObject( stock ) ){
			
			logger.warn("Price or Stock object not valid value, please check!");
			
			return Boolean.TRUE;
			
		}else if( quantity <= 0){
			
			logger.warn("Quantity can not be nagative or zero.");
			
			return Boolean.TRUE;
		}
		

		return Boolean.FALSE;
	}
	
	public boolean buy(Stock stock,Double price, int quantity)throws BusinessException{
		
		logger.info( "Called buy method." );
		
		if( isNotValidateInput( stock, price, quantity ) ){
		
			return Boolean.FALSE;
		
		}
		
		Trade trade = new Trade();
		
		trade.setPrice( price );
		
		trade.setQuantanty( quantity );
		
		trade.setStock( stock );
		
		this.service.buyOperation( trade );
		
		return Boolean.TRUE;
	}
	
	public boolean sell( Stock stock,Double price, int quantity ) throws BusinessException{
		logger.info( "Called sell method." );
		
		if( isNotValidateInput( stock, price, quantity ) ){
			
			return Boolean.FALSE;
		
		}
		
		Trade trade = new Trade();
		
		trade.setPrice( price );
		
		trade.setQuantanty( quantity );
		
		trade.setStock( stock );
		
		this.service.sellOperation( trade );
		
		return Boolean.TRUE;
	}
}
