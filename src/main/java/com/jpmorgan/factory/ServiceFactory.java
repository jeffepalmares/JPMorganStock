package com.jpmorgan.factory;

import com.jpmorgan.service.StockService;
import com.jpmorgan.service.TradeService;
import com.jpmorgan.serviceImpl.StockServiceImpl;
import com.jpmorgan.serviceImpl.TradeServiceImpl;

public class ServiceFactory {
	
	public static TradeService createTradeService(){
		return new TradeServiceImpl(RepositoryFactory.createTradeRepositoryInstance());
	}
	public static StockService createStockService(){
		return new StockServiceImpl(RepositoryFactory.createTradeRepositoryInstance());
	}
}
