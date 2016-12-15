package com.jpmorgan.test;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.jpmorgan.controller.StockController;
import com.jpmorgan.controller.TradeController;

public class TradeRecordedTest {

	UtilTest utilTest = new UtilTest();

	
	@Test
	public void testCalculateVolumeWeightedStockPriceWithTradeRecorded() {
		
		doSomeTrade();
		
		StockController stockController = new StockController();
		
		Double value = stockController.calculateVolumeWeightedStockPrice();
		
		System.out.println( "Volume Weighted Stock Price value: " + value );
		
		assertNotNull( value ); 
	}

	@Test
	public void testCalculateGBCEWithTradeRecorded() {
		
		doSomeTrade();
		
		StockController stockController = new StockController();
		
		Double value = stockController.calculateGBCE();
		
		System.out.println( "GBCE value: " + value );
		
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
