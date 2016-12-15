package com.jpmorgan.model;

public class Stock {

	private Double price;
	private byte lastDividend;
	private byte fixedDividend;
	private int parValue;
	private StockSymbol symbol;
	private StockType type;
	
	
	public Double getPrice() {
		return price;
	}
	public void setPrice( Double price ) {
		this.price = price;
	}
	public byte getLastDividend() {
		return lastDividend;
	}
	public void setLastDividend( byte lastDividend ) {
		this.lastDividend = lastDividend;
	}
	public byte getFixedDividend() {
		return fixedDividend;
	}
	public void setFixedDividend( byte fixedDividend ) {
		this.fixedDividend = fixedDividend;
	}
	public int getParValue() {
		return parValue;
	}
	public void setParValue( int parValue ) {
		this.parValue = parValue;
	}
	public StockSymbol getSymbol() {
		return symbol;
	}
	public void setSymbol( StockSymbol symbol ) {
		this.symbol = symbol;
	}
	public StockType getType() {
		return type;
	}
	public void setType( StockType type ) {
		this.type = type;
	}

	
	
}
