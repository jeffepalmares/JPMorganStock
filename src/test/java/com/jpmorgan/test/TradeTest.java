package com.jpmorgan.test;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.jpmorgan.controller.TradeController;
import com.jpmorgan.exception.BusinessException;
import com.jpmorgan.model.Stock;

public class TradeTest {
	
	UtilTest utilTest = new UtilTest();
	
	@Test(expected=BusinessException.class)
	public void testBuyOperationWithInvalidStock(){
		
		TradeController tradeController = new TradeController();
		
		tradeController.buy( new Stock() , utilTest.getRadomPrice() , utilTest.getRadomQuantity() );
	}

	@Test(expected=BusinessException.class)
	public void testBuyOperationWithInvalidPrice(){
		
		TradeController tradeController = new TradeController();
		
		tradeController.buy( utilTest.createStock() , -20.0 , utilTest.getRadomQuantity() );
	}

	@Test(expected=BusinessException.class)
	public void testBuyOperationWithInvalidQuantanty(){
		
		TradeController tradeController = new TradeController();
		
		tradeController.buy( utilTest.createStock() , utilTest.getRadomPrice() , -2 );
	}

	@Test(expected=BusinessException.class)
	public void testSellOperationWithInvalidStock(){
		
		TradeController tradeController = new TradeController();
		
		tradeController.sell( new Stock() , utilTest.getRadomPrice() , utilTest.getRadomQuantity() );
	}
	
	@Test(expected=BusinessException.class)
	public void testSellOperationWithInvalidPrice(){
		
		TradeController tradeController = new TradeController();
		
		tradeController.sell( utilTest.createStock() , -20.0 , utilTest.getRadomQuantity() );
	}
	
	@Test(expected=BusinessException.class)
	public void testSellOperationWithInvalidQuantanty(){
		
		TradeController tradeController = new TradeController();
		
		 tradeController.sell( utilTest.createStock() , utilTest.getRadomPrice() , -2 );
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
