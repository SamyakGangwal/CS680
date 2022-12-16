package edu.umb.cs680.hw16;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import edu.umb.cs680.hw16.distance.Distance;
import edu.umb.cs680.hw16.distance.Euclidean;

public class DistanceMetricTest {

	@Test
	public void verifyChebyshev() {
		List<Double> p1 = Arrays.asList(2.5, 3.5);
		List<Double> p2 = Arrays.asList(4.5, 5.5);

		assertEquals(2.0, Distance.get(p1, p2, (List<Double> p11, List<Double> p12) -> {
			double max = 0;
			for (int i = 0; i < p1.size(); i++) {
				max = Math.max(max, Math.abs(p1.get(i) - p2.get(i)));
			}
			return max;
		}));
	}

	@Test
	public void verifyEuclidean() {
		List<Double> p1 = Arrays.asList(2.5, 3.5);
		List<Double> p2 = Arrays.asList(4.5, 5.5);

		assertEquals(2.8284271247461903, Distance.get(p1, p2, new Euclidean()));
	}

	@Test
	public void verifyManhattan() {
		List<Double> p1 = Arrays.asList(2.5, 3.5);
		List<Double> p2 = Arrays.asList(4.5, 5.5);

		assertEquals(4.0, Distance.get(p1, p2, (List<Double> p11, List<Double> p12) -> {
			double sum = 0;
			for (int i = 0; i < p11.size(); i++) {
				double diff = Math.abs(p11.get(i) - p12.get(i));
				sum += diff;
			}
			return sum;
		}));
	}

	@Test
	public void verifyEuclideanMatrix() {
		List<List<Double>> expected = new ArrayList<>();

		expected.add(Arrays.asList(0.0, 7.0710678118654755, 5.721013896155122, 19.162985153675823,
				4.72122865364515));
		expected.add(Arrays.asList(7.0710678118654755, 0.0, 2.6324893162176366, 15.067182882012151,
				9.0160967164289));
		expected.add(Arrays.asList(5.721013896155122, 2.6324893162176366, 0.0, 16.738876903783,
				6.745368781616021));
		expected.add(Arrays.asList(19.162985153675823, 15.067182882012151, 16.738876903783, 0.0,
				22.631173190977087));
		expected.add(Arrays.asList(4.72122865364515, 9.0160967164289, 6.745368781616021,
				22.631173190977087, 0.0));

		List<List<Double>> eucPoints = new ArrayList<>();

		eucPoints.add(Arrays.asList(0.0, 5.5, 6.7));
		eucPoints.add(Arrays.asList(5.0, 8.5, 2.7));
		eucPoints.add(Arrays.asList(5.2, 6.8, 4.7));
		eucPoints.add(Arrays.asList(5.9, 23.5, 3.8));
		eucPoints.add(Arrays.asList(2.3, 1.5, 7.7));

		assertTrue(Arrays.deepEquals(expected.toArray(), Distance.matrix(eucPoints).toArray()));
	}

	@Test
	public void verifyManhattanMatrix() {
		List<List<Double>> expected = new ArrayList<>();

		expected.add(Arrays.asList(0.0, 12.0, 8.5, 26.799999999999997, 7.3));
		expected.add(Arrays.asList(12.0, 0.0, 3.9000000000000004, 17.0, 14.7));
		expected.add(Arrays.asList(8.5, 3.9000000000000004, 0.0, 18.299999999999997, 11.2));
		expected.add(Arrays.asList(26.799999999999997, 17.0, 18.299999999999997, 0.0, 29.5));
		expected.add(Arrays.asList(7.3, 14.7, 11.2, 29.5, 0.0));

		List<List<Double>> manhattanPoints = new ArrayList<>();

		manhattanPoints.add(Arrays.asList(0.0, 5.5, 6.7));
		manhattanPoints.add(Arrays.asList(5.0, 8.5, 2.7));
		manhattanPoints.add(Arrays.asList(5.2, 6.8, 4.7));
		manhattanPoints.add(Arrays.asList(5.9, 23.5, 3.8));
		manhattanPoints.add(Arrays.asList(2.3, 1.5, 7.7));

		assertTrue(Arrays.deepEquals(expected.toArray(),
				Distance.matrix(manhattanPoints, (List<Double> p1, List<Double> p2) -> {
					double sum = 0;
					for (int i = 0; i < p1.size(); i++) {
						double diff = Math.abs(p1.get(i) - p2.get(i));
						sum += diff;
					}
					return sum;
				}).toArray()));
	}

	@Test
	public void verifyChebyshevMatrix() {
		List<List<Double>> expected = new ArrayList<>();

		expected.add(Arrays.asList(0.0, 12.0, 8.5, 26.799999999999997, 7.3));
		expected.add(Arrays.asList(12.0, 0.0, 3.9000000000000004, 17.0, 14.7));
		expected.add(Arrays.asList(8.5, 3.9000000000000004, 0.0, 18.299999999999997, 11.2));
		expected.add(Arrays.asList(26.799999999999997, 17.0, 18.299999999999997, 0.0, 29.5));
		expected.add(Arrays.asList(7.3, 14.7, 11.2, 29.5, 0.0));

		List<List<Double>> chebyshevPoints = new ArrayList<>();

		chebyshevPoints.add(Arrays.asList(0.0, 5.5, 6.7));
		chebyshevPoints.add(Arrays.asList(5.0, 8.5, 2.7));
		chebyshevPoints.add(Arrays.asList(5.2, 6.8, 4.7));
		chebyshevPoints.add(Arrays.asList(5.9, 23.5, 3.8));
		chebyshevPoints.add(Arrays.asList(2.3, 1.5, 7.7));

		assertTrue(Arrays.deepEquals(expected.toArray(),
				Distance.matrix(chebyshevPoints, (List<Double> p1, List<Double> p2) -> {
					double sum = 0;
					for (int i = 0; i < p1.size(); i++) {
						double diff = Math.abs(p1.get(i) - p2.get(i));
						sum += diff;
					}
					return sum;
				}).toArray()));
	}
}
