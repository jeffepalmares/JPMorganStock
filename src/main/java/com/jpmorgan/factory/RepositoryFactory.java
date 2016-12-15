package com.jpmorgan.factory;

import com.jpmorgan.repository.TradeRepository;

public class RepositoryFactory {
	
	public static TradeRepository createTradeRepositoryInstance(){
		return TradeRepository.getSharedInstance();
	}
}
