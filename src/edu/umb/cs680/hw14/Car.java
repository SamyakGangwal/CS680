package edu.umb.cs680.hw14;

import java.util.ArrayList;
import java.util.Collections;

public class Car {
	private String model, make;
	private int mileage, year;
	private float price;
	private int dominationCount;

	public Car(String model, String make, int mileage, int year, float price) {
		this.model = model;
		this.make = make;
		this.mileage = mileage;
		this.year = year;
		this.price = price;
	}

	public String getMake() {
		return make;
	}

	public String getModel() {
		return model;
	}

	public int getYear() {
		return year;
	}

	public int getMileage() {
		return mileage;
	}

	public float getPrice() {
		return price;
	}

	public int getDominationCount() {
		return dominationCount;
	}

	public void setDominationCount(ArrayList<Car> usedCars) {
		for (int i = 0; i < usedCars.size(); i++) {

			if ((this.mileage <= usedCars.get(i).mileage) && (this.price >= usedCars.get(i).price)
					&& (this.year <= usedCars.get(i).year)) {

				if ((this.mileage != usedCars.get(i).mileage)
						|| (this.price != usedCars.get(i).price)
						|| (this.year != usedCars.get(i).year)) {
					this.dominationCount++;
				}
			}
		}
	}

	public static void main(String[] args) {
		ArrayList<Car> usedCars = new ArrayList<>();

		usedCars.add(new Car("accord", "honda", 36, 2022, 15000));
		usedCars.add(new Car("gtr r34", "nissan", 35, 1981, 17000));
		usedCars.add(new Car("charger", "dodge", 5, 1969, 45000));
		usedCars.add(new Car("gt", "ford", 12, 1987, 110000));

		Collections.sort(usedCars, (Car car1, Car car2) -> {
			return car2.getYear() - car1.getYear();
		});

		for (Car car : usedCars) {
			car.setDominationCount(usedCars);
		}

		Collections.sort(usedCars, (Car car1, Car car2) -> {
			return car1.getDominationCount() - car2.getDominationCount();
		});


		for (Car car : usedCars) {
			System.out.println(car.getModel() + " " + car.getDominationCount());
		}
	}
}
