package com.jpmorgan.model;

import java.util.Date;

public class Trade {

	private Date date;
	private int quantanty;
	private Double price;
	private OperationType type;
	private Stock stock;
	
	public Date getDate() {
		return date;
	}
	public void setDate( Date date ) {
		this.date = date;
	}
	public int getQuantanty() {
		return quantanty;
	}
	public void setQuantanty( int quantanty ) {
		this.quantanty = quantanty;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice( Double price ) {
		this.price = price;
	}
	public OperationType getType() {
		return type;
	}
	public void setType( OperationType type ) {
		this.type = type;
	}
	public Stock getStock() {
		return stock;
	}
	public void setStock( Stock stock ) {
		this.stock = stock;
	}
	
	
	
}
