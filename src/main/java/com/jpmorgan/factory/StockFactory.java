package com.jpmorgan.factory;

import com.jpmorgan.exception.BusinessException;
import com.jpmorgan.model.Stock;
import com.jpmorgan.model.StockSymbol;
import com.jpmorgan.model.StockType;
import com.jpmorgan.util.Constants;

public class StockFactory {

	public static Stock createStock( StockSymbol symbol, Double price )throws BusinessException{
		
		if( price == null || price <= 0 ){
			
			throw new BusinessException( "Price value not valid!" );
		
		}
		
		switch( symbol ){
		
			case TEA:
			
				return createTea( symbol , price );

			case POP:
				
				return createPop( symbol , price );
			
			case ALE:
			
				return createAle( symbol , price );
			
			case GIN:
			
				return createGin( symbol , price );
			
			case JOE:
			
				return createJoe( symbol , price );
			
			default:
			
				return null;
		}
	}
	
	private static Stock createTea( StockSymbol symbol , Double price ){
		
		Stock stock = new Stock();
		
		stock.setLastDividend( Constants.DefaultValue.ZERO );
		
		stock.setFixedDividend( Constants.DefaultValue.ZERO );
		
		stock.setParValue( Constants.DefaultValue.HUNDRED );
		
		stock.setSymbol( symbol );

		stock.setPrice( price );
		
		stock.setType( StockType.Common );
		
		return stock;
	}
	
	private static Stock createPop( StockSymbol symbol, Double price ){
		
		Stock stock = new Stock();
		
		stock.setLastDividend( Constants.DefaultValue.EIGHT );
		
		stock.setFixedDividend( Constants.DefaultValue.ZERO );
		
		stock.setParValue( Constants.DefaultValue.HUNDRED );
		
		stock.setSymbol( symbol );
		
		stock.setPrice( price );
		
		stock.setType( StockType.Common );
		
		return stock;
		
	}
	private static Stock createAle( StockSymbol symbol, Double price ){
		
		Stock stock = new Stock();
		
		stock.setLastDividend( Constants.DefaultValue.TWENTY_THREE );
		
		stock.setFixedDividend( Constants.DefaultValue.ZERO );
		
		stock.setParValue( Constants.DefaultValue.SIXTY );
		
		stock.setSymbol( symbol );
		
		stock.setPrice( price );
		
		stock.setType( StockType.Common );
		
		return stock;
		
	}
	private static Stock createGin( StockSymbol symbol, Double price ){
		
		Stock stock = new Stock();
		
		stock.setLastDividend( Constants.DefaultValue.EIGHT );
		
		stock.setFixedDividend( Constants.DefaultValue.TWO );
		
		stock.setParValue( Constants.DefaultValue.HUNDRED );
		
		stock.setSymbol( symbol );
		
		stock.setPrice( price );
		
		stock.setType( StockType.Preferred );
		
		return stock;
	}
	private static Stock createJoe( StockSymbol symbol, Double price ){
		
		Stock stock = new Stock();
		
		stock.setLastDividend( Constants.DefaultValue.THIRTEEN );
		
		stock.setFixedDividend( Constants.DefaultValue.ZERO );
		
		stock.setParValue( Constants.DefaultValue.TWO_HUNDRED_FIFTY );
		
		stock.setSymbol( symbol );
		
		stock.setPrice( price );
		
		stock.setType( StockType.Common );
		
		return stock;
	
	}
}
