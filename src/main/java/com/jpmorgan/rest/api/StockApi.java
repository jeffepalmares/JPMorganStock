package com.jpmorgan.rest.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jpmorgan.controller.StockController;
import com.jpmorgan.factory.StockFactory;
import com.jpmorgan.model.StockSymbol;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@RestController
public class StockApi {

	private StockController stockController = new StockController();
	
	@RequestMapping( value = "/stockApi/Stock/DividendYield" , method = RequestMethod.GET )
	@ApiOperation(value = "getDividendYield")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "symbol", value = "ALE,GIN,JOE,POP,TEA", required = true, dataType = "string", paramType = "query"),
        @ApiImplicitParam(name = "price", required = true, dataType = "Double", paramType = "query")
      })
	public String calculateDividendYield( @RequestParam( name="symbol", required= true ) String symbol, 
										  @RequestParam( name="price", required= true ) Double price ){
		
		StockSymbol stockSymbol;
		
		try{
			stockSymbol = StockSymbol.valueOf( symbol );
			
			Double value = this.stockController.calculateDividendYield( this.stockController.createStock( stockSymbol, price ) );
			
			return " dividendYield : " + value;
			
		}catch ( IllegalArgumentException e ) {
			
			return " Stock Symbol invalid, please check! ";
			
		}
		
	}

	@RequestMapping( value = "/stockApi/Stock/DividendPERatio", method = RequestMethod.GET )
	@ApiOperation(value = "getDividendYield")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "symbol", value = "ALE,GIN,JOE,POP,TEA", required = true, dataType = "string", paramType = "query"),
		@ApiImplicitParam(name = "price", required = true, dataType = "Double", paramType = "query")
	})
	public String calculatePERario( @RequestParam( name="symbol", required= true ) String symbol, 
			@RequestParam( name="price", required= true ) Double price ){
		
		StockSymbol stockSymbol;
		
		try{
			stockSymbol = StockSymbol.valueOf( symbol );
			
			Double value = this.stockController.calculatePERatio( StockFactory.createStock( stockSymbol, price ) );
			
			return " P/E Ratio : " + value;
			
		}catch ( IllegalArgumentException e ) {
			
			return " Stock Symbol invalid, please check! ";
			
		}
		
	}

	@RequestMapping( value = "/stockApi/Stock/VolumeWeightedStockPrice", method = RequestMethod.GET )
	@ApiOperation( value = "getVolumeWeightedStockPrice" )
	public String calculateVolumeWeightedStockPrice(){
		
		Double value = this.stockController.calculateVolumeWeightedStockPrice();
			
		return " Volume Weighted Stock Price : " + value;
		
	}

	@RequestMapping( value = "/stockApi/Stock/GBCE", method = RequestMethod.GET )
	@ApiOperation( value = "getGBCE" )
	public String calculateGBCE(){
		
		Double value = this.stockController.calculateGBCE();
		
		return " GBCE Value : " + value;
		
	}
	
}
