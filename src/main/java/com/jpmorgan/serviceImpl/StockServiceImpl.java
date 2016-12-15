package com.jpmorgan.serviceImpl;

import java.util.List;

import com.jpmorgan.model.Stock;
import com.jpmorgan.model.Trade;
import com.jpmorgan.repository.TradeRepository;
import com.jpmorgan.service.StockService;

public class StockServiceImpl implements StockService{

	private TradeRepository tradeRepository;
	
	public StockServiceImpl(TradeRepository tradeRepository){
		this.tradeRepository = tradeRepository; 
	}
	
	public Double calculateDividendYield( Stock stock ){
		
		switch( stock.getType() ){
			
			case Common:
			
				return stock.getLastDividend() / stock.getPrice();

			case Preferred:

				return ( stock.getFixedDividend() * stock.getParValue() ) / stock.getPrice();
		}
		
		return null;
	}
	
	public Double calculatePERatio( Stock stock ){
		
		return ( stock.getPrice() / stock.getPrice() ) ;
		
	}
	
	public Double calculateVolumeWeightedStockPrice(){
		
		List<Trade> tradeLastFiveMinutes = this.tradeRepository.getAllLastFiveMinutes();
		
		if( tradeLastFiveMinutes.isEmpty() ){
			
			return 0.0;
			
		}
		
		Double sumPrice = 0.0;
		
		int sumQuantanty = 0;
		
		for( Trade trade : tradeLastFiveMinutes ){
			
			sumPrice += ( trade.getPrice() * trade.getQuantanty() );
		
			sumQuantanty += trade.getQuantanty();
		
		}
		
		return ( sumPrice /  sumQuantanty );
	}
	
	public Double calculateGBCE(){
		
		List<Trade> trades = this.tradeRepository.getAllLastFiveMinutes();
		
		if( trades.isEmpty() ){
			
			return 0.0;
			
		}
		
			Double priceCalc = null;
		
		for( Trade trade : trades ){
		
			if( priceCalc == null ){
			
				priceCalc = trade.getStock().getPrice();
			
			}else{
			
				priceCalc = priceCalc * trade.getStock().getPrice();
				
			}
		}
		
		return Math.pow( priceCalc, trades.size() );
		
	}
	
	
}
