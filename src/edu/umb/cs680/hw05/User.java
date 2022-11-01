package edu.umb.cs680.hw05;

public class User {
	private String firstName;
	private String lastNmae;
	private EncryptedString password;

	public User(String firstName, String lastName, EncryptedString password) {
		this.firstName = firstName;
		this.lastNmae = lastName;
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastNmae;
	}

	public boolean comparePassword(EncryptedString pwd) {
		if (this.password.getEncrypted_string().equals(pwd.getEncrypted_string())) {
			return true;
		}

		return false;
	}
}
