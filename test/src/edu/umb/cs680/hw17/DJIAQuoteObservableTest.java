package edu.umb.cs680.hw17;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class DJIAQuoteObservableTest {

	@Test
	public void notifyStockQuoteObservers() {
		LineChartObserver2 lineChartObserver = new LineChartObserver2();
		T3DObserver2 t3dObserver = new T3DObserver2();

		Observer updateTableObserver = (Observable sender, Object event) -> {
			System.out.println("Stock: " + ((Double) event));
		};


		DJIAQuoteObservable djt = new DJIAQuoteObservable();

		djt.addObserver(updateTableObserver);
		djt.addObserver(t3dObserver);
		djt.addObserver(lineChartObserver);

		djt.changeQuote(568.6);

		assertEquals(568.6, lineChartObserver.getS());
		assertEquals(568.6, t3dObserver.getS());

		djt.changeQuote(1456.6);


		assertEquals(1456.6, t3dObserver.getS());
		assertEquals(1456.6, lineChartObserver.getS());

		djt.removeObserver(updateTableObserver);
		djt.removeObserver(lineChartObserver);
		djt.removeObserver(t3dObserver);

		assertTrue(djt.getObservers().isEmpty());

	}
}
