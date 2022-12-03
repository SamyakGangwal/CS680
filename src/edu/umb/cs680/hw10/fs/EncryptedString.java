package edu.umb.cs680.hw10.fs;

public class EncryptedString {
	private String encrypted_string;

	public EncryptedString(String pwd) {
		this.encrypted_string = pwd;
	}

	public String getEncrypted_string() {
		return encrypted_string;
	}
}
