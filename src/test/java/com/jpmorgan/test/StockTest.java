package com.jpmorgan.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.apache.log4j.Logger;
import org.junit.Test;

import com.jpmorgan.controller.StockController;
import com.jpmorgan.model.Stock;

public class StockTest {
	
	private final static Logger logger = Logger.getLogger( StockTest.class );
	
	private UtilTest utilTest = new UtilTest();
	
	@Test
	public void testCreateStockWithNullValues() {
		
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
		
		logger.info( "Dividend Yield value: " + value );
		
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
		
		logger.info( "P/Ratio value: " + value );
		
		assertNotNull( value );
	}

	@Test
	public void testCalculateVolumeWeightedStockPriceWithoutTradeRecorded() {
		
		StockController stockController = new StockController();
		
		Double value = stockController.calculateVolumeWeightedStockPrice();
		
		logger.info( "Volume Weighted Stock Price value: " + value );
		
		assertEquals( value , 0,0 ); 
	}

	@Test
	public void testCalculateGBCEWithoutTradeRecorded() {
		
		StockController stockController = new StockController();
		
		Double value = stockController.calculateGBCE();
		
		logger.info( "GBCE value: " + value );
		
		assertEquals( value , 0,0 );
	}

}
