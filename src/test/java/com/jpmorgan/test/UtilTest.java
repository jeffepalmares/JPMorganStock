package com.jpmorgan.test;

import java.util.Random;

import com.jpmorgan.controller.StockController;
import com.jpmorgan.model.Stock;
import com.jpmorgan.model.StockSymbol;

public class UtilTest {

	public Stock createStock(){
		
		StockController stockController = new StockController();
		
		return stockController.createStock( StockSymbol.JOE, getRadomPrice() );
	
	}
	
	public Double getRadomPrice(){
		
		Random random = new Random();
		
		return Math.abs( random.nextDouble() );
	
	}

	public int getRadomQuantity(){
		
		Random random = new Random();
		
		return Math.abs( random.nextInt() );
		
	}
}
