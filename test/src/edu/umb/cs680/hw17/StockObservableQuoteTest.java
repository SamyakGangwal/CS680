package edu.umb.cs680.hw17;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class StockObservableQuoteTest {
	
	@Test
	public void notifyStockQuoteObservers() {
		LineChartObserver lineChartObserver = new LineChartObserver();
		T3DObserver t3dObserver = new T3DObserver();
		TableObserver tableObserver = new TableObserver();
		

		StockQuoteObservable st = new StockQuoteObservable();

		st.addObserver(tableObserver);
		st.addObserver(t3dObserver);
		st.addObserver(lineChartObserver);

		st.changeQuote("AAPL", 568.6);

		assertEquals("AAPL", tableObserver.getS().getTicker());
		assertEquals("AAPL", t3dObserver.getS().getTicker());
		assertEquals("AAPL", lineChartObserver.getS().getTicker());

		assertEquals(568.6, tableObserver.getS().getQuote());
		assertEquals(568.6, t3dObserver.getS().getQuote());
		assertEquals(568.6, lineChartObserver.getS().getQuote());


		st.changeQuote("GOOGL", 1456.6);

		assertEquals("GOOGL", tableObserver.getS().getTicker());
		assertEquals("GOOGL", t3dObserver.getS().getTicker());
		assertEquals("GOOGL", lineChartObserver.getS().getTicker());

		assertEquals(1456.6, tableObserver.getS().getQuote());
		assertEquals(1456.6, t3dObserver.getS().getQuote());
		assertEquals(1456.6, lineChartObserver.getS().getQuote());

	}
}
