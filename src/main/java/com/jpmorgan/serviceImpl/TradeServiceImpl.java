package com.jpmorgan.serviceImpl;

import java.util.Date;

import com.jpmorgan.model.OperationType;
import com.jpmorgan.model.Trade;
import com.jpmorgan.repository.TradeRepository;
import com.jpmorgan.service.TradeService;

public class TradeServiceImpl implements TradeService{

	private TradeRepository repository;
	
	public TradeServiceImpl(TradeRepository repository){
		this.repository = repository;
	}
	
	@Override
	public void buyOperation( Trade trade ) {
		trade.setDate(new Date());
		trade.setType(OperationType.Buy);
		this.repository.saveTrade(trade);
	}

	@Override
	public void sellOperation( Trade trade) {
		trade.setDate(new Date());
		trade.setType(OperationType.Sell);
		this.repository.saveTrade(trade);
	}
	

}
