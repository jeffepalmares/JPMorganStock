package com.jpmorgan.test;

import static org.junit.Assert.assertNotNull;

import org.apache.log4j.Logger;
import org.junit.Test;

import com.jpmorgan.controller.StockController;
import com.jpmorgan.controller.TradeController;

public class TradeRecordedTest {

	private final static Logger logger = Logger.getLogger( TradeRecordedTest.class );
	
	private UtilTest utilTest = new UtilTest();

	
	@Test
	public void testCalculateVolumeWeightedStockPriceWithTradeRecorded() {
		
		doSomeTrade();
		
		StockController stockController = new StockController();
		
		Double value = stockController.calculateVolumeWeightedStockPrice();
		
		logger.info( "Volume Weighted Stock Price value: " + value );
		
		assertNotNull( value ); 
	}

	@Test
	public void testCalculateGBCEWithTradeRecorded() {
		
		doSomeTrade();
		
		StockController stockController = new StockController();
		
		Double value = stockController.calculateGBCE();
		
		logger.info( "GBCE value: " + value );
		
		assertNotNull( value );
	}
	
	private void doSomeTrade(){
		
		TradeController tradeController = new TradeController();
		
		tradeController.buy( utilTest.createStock() , utilTest.getRadomPrice() , utilTest.getRadomQuantity() );
		
		tradeController.buy( utilTest.createStock() , utilTest.getRadomPrice() , utilTest.getRadomQuantity() );
		
		tradeController.buy( utilTest.createStock() , utilTest.getRadomPrice() , utilTest.getRadomQuantity() );

		tradeController.sell( utilTest.createStock() , utilTest.getRadomPrice() , utilTest.getRadomQuantity() );
		
		tradeController.sell( utilTest.createStock() , utilTest.getRadomPrice() , utilTest.getRadomQuantity() );
		
		tradeController.sell( utilTest.createStock() , utilTest.getRadomPrice() , utilTest.getRadomQuantity() );
		
	}
	
}
