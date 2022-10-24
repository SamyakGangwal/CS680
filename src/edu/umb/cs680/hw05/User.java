package edu.umb.cs680.hw05;

public class User {
	private String firstName;
	private String lastNmae;

	public User(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastNmae = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastNmae() {
		return lastNmae;
	}
}
