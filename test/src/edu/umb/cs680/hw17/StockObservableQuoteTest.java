package edu.umb.cs680.hw17;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class StockObservableQuoteTest {
	
	@Test
	public void notifyStockQuoteObservers() {
		LineChartObserver lineChartObserver = new LineChartObserver();
		T3DObserver t3dObserver = new T3DObserver();
		
		Observer updateTableObserver = (Observable sender, Object event) -> {System.out.println("Stock: " + ((StockEvent)event).getTicker());};
		

		StockQuoteObservable st = new StockQuoteObservable();

		st.addObserver(updateTableObserver);
		st.addObserver(t3dObserver);
		st.addObserver(lineChartObserver);

		st.changeQuote("AAPL", 568.6);

		assertEquals("AAPL", lineChartObserver.getS().getTicker());
		assertEquals("AAPL", t3dObserver.getS().getTicker());
		

		assertEquals(568.6, t3dObserver.getS().getQuote());
		assertEquals(568.6, lineChartObserver.getS().getQuote());


		st.changeQuote("GOOGL", 1456.6);

		
		assertEquals("GOOGL", t3dObserver.getS().getTicker());
		assertEquals("GOOGL", lineChartObserver.getS().getTicker());

		assertEquals(1456.6, t3dObserver.getS().getQuote());
		assertEquals(1456.6, lineChartObserver.getS().getQuote());

		st.removeObserver(updateTableObserver);
		st.removeObserver(lineChartObserver);
		st.removeObserver(t3dObserver);

		assertTrue(st.getObservers().isEmpty());

	}
}
