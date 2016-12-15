package com.jpmorgan.service;

import com.jpmorgan.model.Stock;

public interface StockService {

	public Double calculateDividendYield(Stock stock);
	public Double calculatePERatio(Stock stock);
	public Double calculateVolumeWeightedStockPrice(); 
	public Double calculateGBCE(); 
}
