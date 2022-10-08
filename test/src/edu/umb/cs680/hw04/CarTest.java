package edu.umb.cs680.hw04;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class CarTest {
	private String[] carToStringArray(Car c) {
		String[] car_info = {
			c.getMake(),
			c.getModel(),
			Integer.toString(c.getMileage()),
			Integer.toString(c.getYear()),
			Float.toString(c.getPrice()),
		};

		return car_info;
	}

	@Test
	public void verifyCarEqualityWithMakeModelYear() {
		String[] expected = {"Dodge", "Charger", "30", "1969", "45000.0"};

		Car actual = new Car("Dodge", "Charger", 30, 1969, 45000f);

		assertArrayEquals(expected, carToStringArray(actual));
	}
}
