package edu.umb.cs680.hw05;

public class Authenticator {
	public static boolean authenticate(User userObject, EncryptedString pwd) {
		if (userObject.comparePassword(pwd)) {
			return true;
		}

		return false;
	}
}
