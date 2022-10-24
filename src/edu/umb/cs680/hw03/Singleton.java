package edu.umb.cs680.hw03;

public class Singleton {
	private int number;

	private Singleton(int num) {
		this.number = num;
	};

	private static Singleton instance = null;

	public static Singleton getInstance(int num) {
		if (instance == null) {
			instance = new Singleton(num);
		}
		return instance;
	}

	public int getNumber() {
		return this.number;
	}

	public static void main(String[] args) {
		Singleton instance1 = Singleton.getInstance(5);

		System.out.println("instance 1 value: " + instance1.getNumber());

		Singleton instance2 = Singleton.getInstance(6);

		System.out.println("instance 2 value: " + instance2.getNumber());

		System.out.println("Hashcode instance 1: " + instance1.hashCode());

		System.out.println("Hashcode instance 2: " + instance2.hashCode());
	}
}