package com.jpmorgan.service;

import com.jpmorgan.model.Trade;

public interface TradeService {

	public void buyOperation(Trade trade);
	public void sellOperation(Trade trade);
}
