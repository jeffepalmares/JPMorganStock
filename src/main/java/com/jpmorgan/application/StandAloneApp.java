package com.jpmorgan.application;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.apache.log4j.Logger;

import com.jpmorgan.controller.StockController;
import com.jpmorgan.controller.TradeController;
import com.jpmorgan.model.Stock;
import com.jpmorgan.model.StockSymbol;

public class StandAloneApp {
	
	private final static Logger logger = Logger.getLogger(StandAloneApp.class);
	
	private Random randomGenerator;
	private StockController stockController;
	private TradeController tradeController;
	
	public StandAloneApp(){
		this.randomGenerator = new Random();
		this.stockController = new StockController();
		this.tradeController = new TradeController();
	}
	private List<Stock> getStockList(){
		List<Stock> stockList = new ArrayList<Stock>();
		stockList.add(this.stockController.createStock(StockSymbol.ALE, getRandomPrice()));
		stockList.add(this.stockController.createStock(StockSymbol.GIN, getRandomPrice()));
		stockList.add(this.stockController.createStock(StockSymbol.JOE, getRandomPrice()));
		stockList.add(this.stockController.createStock(StockSymbol.POP, getRandomPrice()));
		stockList.add(this.stockController.createStock(StockSymbol.TEA, getRandomPrice()));
		return stockList;
	}
	
	public static void runStandAlone(){
		
		StandAloneApp app = new StandAloneApp();

		for(Stock stock : app.getStockList()){
			logger.info("The Dividend Yield is " + app.getStockController().calculateDividendYield(stock));
			logger.info("The P/E Ratio is " + app.getStockController().calculateDividendYield(stock));
			app.getTradeController().buy(stock, app.getRandomPrice() , app.getRandomQuantity());
			app.getTradeController().sell(stock, app.getRandomPrice() , app.getRandomQuantity());
		}
		logger.info("The Volume Weighted Stock Price is " + app.getStockController().calculateVolumeWeightedStockPrice());
		logger.info("The GBCE Price is " + app.getStockController().calculateGBCE());
		
	}
	
	
	private Double getRandomPrice(){
		logger.info("Generating random price");
		return Math.abs(this.randomGenerator.nextDouble());
	}
	private int getRandomQuantity(){
		logger.info("Generating random Quantity");
		return Math.abs(this.randomGenerator.nextInt());
	}
	public StockController getStockController() {
		return stockController;
	}
	public void setStockController( StockController stockController ) {
		this.stockController = stockController;
	}
	public TradeController getTradeController() {
		return tradeController;
	}
	public void setTradeController( TradeController tradeController ) {
		this.tradeController = tradeController;
	}
	
}
