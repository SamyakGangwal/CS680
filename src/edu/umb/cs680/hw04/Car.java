package edu.umb.cs680.hw04;

public class Car {
	private String make;
	private String model;
	private int mileage;
	private int year;
	private float price;

	public Car(String make, String model, int mileage, int year, float price) {
		this.make = make;
		this.model = model;
		this.mileage = mileage;
		this.year = year;
		this.price = price;
	}

	public String getModel() {
		return model;
	}

	public String getMake() {
		return make;
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

	public static void main(String[] args) {
		Car gtr = new Car("Nissan", "GTR R34", 15, 1992, 25000.00f);

		System.out.println("Car Info:");

		System.out.println(gtr.getMake() + "\n" + gtr.model + "\n" + gtr.mileage + "\n" + gtr.getYear() + "\n" + gtr.getPrice());

	}

}