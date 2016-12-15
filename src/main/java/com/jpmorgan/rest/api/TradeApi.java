package com.jpmorgan.rest.api;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jpmorgan.controller.TradeController;
import com.jpmorgan.exception.BusinessException;
import com.jpmorgan.factory.StockFactory;
import com.jpmorgan.model.Stock;
import com.jpmorgan.model.StockSymbol;
import com.jpmorgan.rest.request.TradeRequest;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@RestController
public class TradeApi {

	private TradeController tradeController = new TradeController();
	
	@RequestMapping( value = "/StockApi/Trade/buy" , method = RequestMethod.PUT)
	@ApiOperation( value = "tradeBuyOperation" )
    public String tradeBuyOperation( @RequestBody TradeRequest requestBody ){
		
		StockSymbol stockSymbol;
		
		try{
			
			stockSymbol = StockSymbol.valueOf( requestBody.getStockSymbol() );
			
			Stock stock = StockFactory.createStock( stockSymbol, requestBody.getPrice() );
			
			if( tradeController.buy( stock , requestBody.getPrice() , requestBody.getQuantity() ) ){
				
				return "Operation successfully";
			}
				
			return "Ops.. Sorry something went wrong, please try again!";
			
		}catch ( IllegalArgumentException e ) {
			
			throw new BusinessException (" Stock Symbol invalid, please check! ");
			
		}
		
	}
	
	@RequestMapping( value = "/StockApi/Trade/sell" , method = RequestMethod.PUT)
	@ApiOperation( value = "doTradeSell" )
	@ApiImplicitParams({
        @ApiImplicitParam(paramType = "body" )
	})
	public String tradeSellOperation( @RequestBody TradeRequest requestBody ){
		
		StockSymbol stockSymbol;
		
		try{
			
			stockSymbol = StockSymbol.valueOf( requestBody.getStockSymbol() );
			
			Stock stock = StockFactory.createStock( stockSymbol, requestBody.getPrice() );
			
			if( tradeController.sell( stock , requestBody.getPrice() , requestBody.getQuantity() ) ){
				
				return "Operation successfully";
			}
			
			return "please Check your request!";
			
		}catch ( IllegalArgumentException e ) {
			
			throw new BusinessException (" Stock Symbol invalid, please check! ");
			
		}
		
	}
	
}
