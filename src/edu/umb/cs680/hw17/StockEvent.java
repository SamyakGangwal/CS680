package edu.umb.cs680.hw17;

public class StockEvent {
	private String ticket;
	private double quote;

	public String getTicker() {
		return ticket;
	}


	public double getQuote() {
		return quote;
	}

	public StockEvent(String ticket, double quote) {
		this.ticket = ticket;
		this.quote = quote;
	}

	public static void main(String[] args) {
		System.out.println("Test");
	}
}
