package com.jpmorgan.factory;

import java.util.List;

import com.jpmorgan.exception.BusinessException;
import com.jpmorgan.model.Stock;
import com.jpmorgan.model.StockSymbol;
import com.jpmorgan.model.StockType;
import com.jpmorgan.util.Constants;

public class StockFactory {
	private static List<Stock> indexs; 
	public static Stock createStock(StockSymbol symbol, Double price)throws BusinessException{
		if(price == null){
			throw new BusinessException("Price can not be null!");
		}
		switch(symbol){
			case TEA:
				return createTea(symbol);
			case POP:
				return createPop(symbol);
			case ALE:
				return createAle(symbol);
			case GIN:
				return createGin(symbol);
			case JOE:
				return createJoe(symbol);
			default:
				return null;
		}
	}
	
	private static Stock createTea(StockSymbol symbol){
		Stock stock = new Stock();
		stock.setLastDividend(Constants.DefaultValue.ZERO);
		stock.setFixedDividend(Constants.DefaultValue.ZERO);
		stock.setParValue(Constants.DefaultValue.HUNDRED);
		stock.setSymbol(symbol);
		stock.setType(StockType.Common);
		return stock;
	}
	private static Stock createPop(StockSymbol symbol){
		Stock stock = new Stock();
		stock.setLastDividend(Constants.DefaultValue.EIGHT);
		stock.setFixedDividend(Constants.DefaultValue.ZERO);
		stock.setParValue(Constants.DefaultValue.HUNDRED);
		stock.setSymbol(symbol);
		stock.setType(StockType.Common);
		return stock;
	}
	private static Stock createAle(StockSymbol symbol){
		Stock stock = new Stock();
		stock.setLastDividend(Constants.DefaultValue.TWENTY_THREE);
		stock.setFixedDividend(Constants.DefaultValue.ZERO);
		stock.setParValue(Constants.DefaultValue.SIXTY);
		stock.setSymbol(symbol);
		stock.setType(StockType.Common);
		return stock;
	}
	private static Stock createGin(StockSymbol symbol){
		Stock stock = new Stock();
		stock.setLastDividend(Constants.DefaultValue.EIGHT);
		stock.setFixedDividend(Constants.DefaultValue.TWO);
		stock.setParValue(Constants.DefaultValue.HUNDRED);
		stock.setSymbol(symbol);
		stock.setType(StockType.Preferred);
		return stock;
	}
	private static Stock createJoe(StockSymbol symbol){
		Stock stock = new Stock();
		stock.setLastDividend(Constants.DefaultValue.THIRTEEN);
		stock.setFixedDividend(Constants.DefaultValue.ZERO);
		stock.setParValue(Constants.DefaultValue.TWO_HUNDRED_FIFTY);
		stock.setSymbol(symbol);
		stock.setType(StockType.Common);
		return stock;
	}
}
