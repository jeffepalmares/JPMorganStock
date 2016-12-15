package com.jpmorgan.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.jpmorgan.controller.TradeController;
import com.jpmorgan.model.Stock;

public class TradeTest {
	
	UtilTest utilTest = new UtilTest();
	
	@Test
	public void testBuyOperationWithInvalidStock(){
		
		TradeController tradeController = new TradeController();
		
		assertFalse( tradeController.buy( new Stock() , utilTest.getRadomPrice() , utilTest.getRadomQuantity() ) );
	}

	@Test
	public void testBuyOperationWithInvalidPrice(){
		
		TradeController tradeController = new TradeController();
		
		assertFalse( tradeController.buy( utilTest.createStock() , -20.0 , utilTest.getRadomQuantity() ) );
	}

	@Test
	public void testBuyOperationWithInvalidQuantanty(){
		
		TradeController tradeController = new TradeController();
		
		assertFalse( tradeController.buy( utilTest.createStock() , utilTest.getRadomPrice() , -2 ) );
	}

	@Test
	public void testSellOperationWithInvalidStock(){
		
		TradeController tradeController = new TradeController();
		
		assertFalse( tradeController.sell( new Stock() , utilTest.getRadomPrice() , utilTest.getRadomQuantity() ) );
	}
	
	@Test
	public void testSellOperationWithInvalidPrice(){
		
		TradeController tradeController = new TradeController();
		
		assertFalse( tradeController.sell( utilTest.createStock() , -20.0 , utilTest.getRadomQuantity() ) );
	}
	
	@Test
	public void testSellOperationWithInvalidQuantanty(){
		
		TradeController tradeController = new TradeController();
		
		assertFalse( tradeController.sell( utilTest.createStock() , utilTest.getRadomPrice() , -2 ) );
	}

	@Test
	public void testBuyOperation(){
		
		TradeController tradeController = new TradeController();
		
		assertTrue( tradeController.buy( utilTest.createStock() , utilTest.getRadomPrice() , utilTest.getRadomQuantity() ) );
	}

	@Test
	public void testSellOperation(){
		
		TradeController tradeController = new TradeController();
		
		assertTrue( tradeController.sell( utilTest.createStock() , utilTest.getRadomPrice() , utilTest.getRadomQuantity() ) );
	}
	
}
