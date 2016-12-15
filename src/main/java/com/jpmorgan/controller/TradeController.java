package com.jpmorgan.controller;

import org.apache.log4j.Logger;

import com.jpmorgan.exception.BusinessException;
import com.jpmorgan.factory.ServiceFactory;
import com.jpmorgan.model.Stock;
import com.jpmorgan.model.Trade;
import com.jpmorgan.service.TradeService;

public class TradeController {

	private final static Logger logger = Logger.getLogger(StockController.class);
	
	private TradeService service;
	
	public TradeController(){
		this.service = ServiceFactory.createTradeService();
		
	}
	
	public void buy(Stock stock,Double price, int quantity)throws BusinessException{
		logger.info("Called buy method.");
		
		if(price == null || stock == null){
		
			logger.error("Price or Stock can not be null");
			
			throw new BusinessException("Price or Stock can not be null");
		}
		Trade trade = new Trade();
		trade.setPrice(price);
		trade.setQuantanty(quantity);
		trade.setStock(stock);
		this.service.buyOperation(trade);
		
	}
	public void sell(Stock stock,Double price, int quantity) throws BusinessException{
		logger.info("Called sell method.");
		
		if(price == null || stock == null){
		
			logger.error("Price or Stock can not be null");
			
			throw new BusinessException("Price or Stock can not be null");
		}
		Trade trade = new Trade();
		trade.setPrice(price);
		trade.setQuantanty(quantity);
		trade.setStock(stock);
		this.service.sellOperation(trade);
		
	}
}
