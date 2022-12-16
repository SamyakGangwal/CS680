package edu.umb.cs680.hw14;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import java.util.ArrayList;
import java.util.Collections;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class ComparatorTest {
	private static ArrayList<Car> usedCars = new ArrayList<>();

	@BeforeAll
	public static void setUpList() {
		usedCars.add(new Car("accord", "honda", 36, 2022, 15000));
		usedCars.add(new Car("gtr r34", "nissan", 35, 1981, 17000));
		usedCars.add(new Car("charger", "dodge", 5, 1969, 45000));
		usedCars.add(new Car("gt", "ford", 12, 1987, 110000));
	}

	@Test
	public void checkMileageComparator() {
		ArrayList<String> expected = new ArrayList<>();

		expected.add("charger");
		expected.add("gt");
		expected.add("gtr r34");
		expected.add("accord");

		Collections.sort(usedCars, (Car car1, Car car2) -> {
			return car1.getMileage() - car2.getMileage();
		});


		ArrayList<String> actual = new ArrayList<>();

		for (Car car: usedCars) {
			actual.add(car.getModel());
		}

		assertArrayEquals(expected.toArray(), actual.toArray());
	}

	@Test
	public void checkParetoComparator() {
		ArrayList<String> expected = new ArrayList<>();

		expected.add("accord");
		expected.add("gt");
		expected.add("gtr r34");
		expected.add("charger");

		for (Car car : usedCars) {
			car.setDominationCount(usedCars);
		}

		Collections.sort(usedCars, (Car car1, Car car2) -> {
			return car1.getDominationCount() - car2.getDominationCount();
		});

		ArrayList<String> actual = new ArrayList<>();

		for (Car car: usedCars) {
			actual.add(car.getModel());
		}

		assertArrayEquals(expected.toArray(), actual.toArray());
	}

	@Test
	public void checkPriceComparator() {
		ArrayList<String> expected = new ArrayList<>();

		expected.add("accord");
		expected.add("gtr r34");
		expected.add("charger");
		expected.add("gt");

		Collections.sort(usedCars, (Car car1, Car car2) -> {
			return (int)car1.getPrice() - (int)car2.getPrice();
		});

		ArrayList<String> actual = new ArrayList<>();

		for (Car car: usedCars) {
			actual.add(car.getModel());
		}

		assertArrayEquals(expected.toArray(), actual.toArray());
	}

	@Test
	public void checkYearComparator() {
		ArrayList<String> expected = new ArrayList<>();

		expected.add("accord");
		expected.add("gt");
		expected.add("gtr r34");
		expected.add("charger");

		Collections.sort(usedCars, (Car car1, Car car2) -> {
			return car2.getYear() - car1.getYear();
		});

		ArrayList<String> actual = new ArrayList<>();

		for (Car car: usedCars) {
			actual.add(car.getModel());
		}

		assertArrayEquals(expected.toArray(), actual.toArray());
	}
}