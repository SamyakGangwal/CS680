package edu.umb.cs680.hw11.distance;

import java.util.List;

public class Chebyshev implements DistanceMetric {
	public Chebyshev() {}

	@Override
	public double distance(List<Double> p1, List<Double> p2) {
		double max = 0;
		for (int i = 0; i < p1.size(); i++) {
			max = Math.max(max, Math.abs(p1.get(i) - p2.get(i)));
		}
		return max;
	}

}
