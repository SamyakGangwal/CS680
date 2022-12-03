package edu.umb.cs680.hw10.fs;

public class Authenticator {
	public static boolean authenticate(User userObject, EncryptedString pwd) {
		if (userObject.comparePassword(pwd)) {
			return true;
		}

		return false;
	}
}
