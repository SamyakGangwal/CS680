package edu.umb.cs680.hw17;

public class LineChartObserver implements Observer<StockEvent> {
	private StockEvent s;

	public StockEvent getS() {
		return s;
	}

	@Override
	public void update(Observable sender, StockEvent event) {
		if (sender instanceof StockQuoteObservable) {
			StockEvent t = new StockEvent((((StockEvent) event).getTicker()),
					((StockEvent) event).getQuote());

			this.s = t;

			System.out.println("Processing Stock event LineChartObserver");
		}


	}


}
