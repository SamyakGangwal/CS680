package edu.umb.cs680.hw17;

public class DJIAQuoteObservable extends Observable<Double> {
	Double quote;

	public DJIAQuoteObservable() {}

	public void changeQuote(double q) {
		this.quote = q;

		notifyObservers(q);
	}
}


