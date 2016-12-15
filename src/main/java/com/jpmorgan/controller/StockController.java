package com.jpmorgan.controller;

import org.apache.log4j.Logger;

import com.jpmorgan.exception.BusinessException;
import com.jpmorgan.factory.ServiceFactory;
import com.jpmorgan.factory.StockFactory;
import com.jpmorgan.model.Stock;
import com.jpmorgan.model.StockSymbol;
import com.jpmorgan.service.StockService;

public class StockController {

	private final static Logger logger = Logger.getLogger(StockController.class);
	
	private StockService service;
	
	public StockController(){
		this.service = ServiceFactory.createStockService();
	}
	
	public Stock createStock(StockSymbol symbol, Double price){
		logger.info("Called createStock method.");
		try{	
			Stock stock = StockFactory.createStock(symbol,price);
			
			stock.setPrice(price);
		
			return stock;
			
		}catch(BusinessException ex){
			
			logger.error(ex.getMessage());
			
			return null;
		}
	}
	
	public Double calculateDividendYield(Stock stock){
		logger.info("Called calculateDividendYield method.");
		return service.calculateDividendYield(stock);
	}
	
	public Double calculatePERatio(Stock stock){
		logger.info("Called calculatePERatio method.");
		return service.calculatePERatio(stock);
	}
	
	public Double calculateVolumeWeightedStockPrice(){
		logger.info("Called calculateVolumeWeightedStockPrice method.");
		
		return service.calculateVolumeWeightedStockPrice();
		
	}
	public Double calculateGBCE(){
		logger.info("Called calculateGBCE method.");
		
		return service.calculateGBCE();
		
	}
}
