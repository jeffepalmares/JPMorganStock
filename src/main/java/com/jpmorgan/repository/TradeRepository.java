package com.jpmorgan.repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import com.jpmorgan.model.Trade;
import com.jpmorgan.util.Constants;

public class TradeRepository {

	private static TradeRepository sharedInstance;
	private List<Trade> repository;
	
	private TradeRepository(){
		
		this.repository = new ArrayList<Trade>();
		
	}
	
	public void saveTrade( Trade trade ){
		
		this.repository.add( trade );
		
	}
	
	public List<Trade> getAllLastFiveMinutes(){
		
		Date fiveMinutesAgo = new Date( new Date().getTime() - Constants.DefaultValue.FIVE_MINUTES_MILLISECONDS );
		
		return repository.stream().filter( t -> t.getDate().after( fiveMinutesAgo ) ).collect( Collectors.toList() );
		
	}
 	
	public static TradeRepository getSharedInstance(){
		
		if( sharedInstance == null ){
		
			sharedInstance = new TradeRepository();
			
		}
		
		return sharedInstance;
	}
	
}
