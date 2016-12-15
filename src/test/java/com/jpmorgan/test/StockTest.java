package com.jpmorgan.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;

import com.jpmorgan.controller.StockController;
import com.jpmorgan.model.Stock;

public class StockTest {

	UtilTest utilTest = new UtilTest();
	
	@Test
	public void testValidateNullValues() {
		
		StockController stockController = new StockController();
		
		Stock stock = stockController.createStock( null, null );
	
		assertEquals( stock, null );
		
	}
	
	@Test
	public void testCalculateDividendYieldWithInvalidStock() {
		
		StockController stockController = new StockController();
		
		Double value = stockController.calculateDividendYield( new Stock() );
		
		assertNull( value );
	}

	@Test
	public void testCalculateDividendYieldWithValidStock() {
		
		StockController stockController = new StockController();
		
		Double value = stockController.calculateDividendYield( utilTest.createStock() );
		
		System.out.println( "Dividend Yield value: " + value );
		
		assertNotNull( value );
	}

	@Test
	public void testCalculatePERatioWithInvalidStock() {
		
		StockController stockController = new StockController();
		
		Double value = stockController.calculatePERatio( new Stock() );
		
		assertNull( value );
	}

	@Test
	public void testCalculatePERatioWithValidStock() {
		
		StockController stockController = new StockController();
		
		Double value = stockController.calculatePERatio( utilTest.createStock() );
		
		System.out.println( "P/Ratio value: " + value );
		
		assertNotNull( value );
	}

	@Test
	public void testCalculateVolumeWeightedStockPriceWithoutTradeRecorded() {
		
		StockController stockController = new StockController();
		
		Double value = stockController.calculateVolumeWeightedStockPrice();
		
		System.out.println( "Volume Weighted Stock Price value: " + value );
		
		assertEquals( value , 0,0 ); 
	}

	@Test
	public void testCalculateGBCEWithoutTradeRecorded() {
		
		StockController stockController = new StockController();
		
		Double value = stockController.calculateGBCE();
		
		System.out.println( "GBCE value: " + value );
		
		assertEquals( value , 0,0 );
	}

}
