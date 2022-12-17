package edu.umb.cs680.hw17;

public class TableObserver2 implements Observer {
	private Double s;

	public Double getS() {
		return s;
	}

	@Override
	public void update(Observable sender, Object event) {
		if (sender instanceof DJIAQuoteObservable) {

			this.s = (Double)event;

			System.out.println("Processing Stock event TableObserver2");
		}

	}

}
