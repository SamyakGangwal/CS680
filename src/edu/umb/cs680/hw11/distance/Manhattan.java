package edu.umb.cs680.hw11.distance;

import java.util.List;

public class Manhattan implements DistanceMetric {
	public Manhattan() {

	}

	@Override
	public double distance(List<Double> p1, List<Double> p2) {
		
		double sum = 0;
		for (int i = 0; i < p1.size(); i++) {
		  double diff = Math.abs(p1.get(i) - p2.get(i));
		  sum += diff;
		}
		return sum;
	}

}
