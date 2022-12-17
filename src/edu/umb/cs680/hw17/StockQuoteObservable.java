package edu.umb.cs680.hw17;

import java.util.HashMap;

public class StockQuoteObservable extends Observable<StockEvent>{
	HashMap<String, Double> stockPriceQuote;

	public StockQuoteObservable() {
		this.stockPriceQuote = new HashMap<>();
	}

	public void changeQuote(String t,double q) {
		this.stockPriceQuote.put(t, q);
		notifyObservers(new StockEvent(t, q));
	}
}
