package edu.umb.cs680.hw05;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class SecurityContextTest {
	@Test
	public void loginTrue() {
		String firstName = "Alan";
		String lastName = "Turing";

		EncryptedString pwd = new EncryptedString("pwd");

		User userObject = new User(firstName, lastName);

		SecurityContext ctx = new SecurityContext(userObject);

		try {
			ctx.login(pwd);
			assertTrue(ctx.getState() instanceof LoggedIn);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Test
	public void loginFalse() {
		String firstName = "Alan";
		String lastName = "Turing";

		EncryptedString pwd = new EncryptedString("pwd");

		User userObject = new User(firstName, lastName);

		SecurityContext ctx = new SecurityContext(userObject);

		try {
			ctx.logout();
			assertFalse(ctx.getState() instanceof LoggedIn);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	@Test
	public void loginLogoutLogin() {
		String firstName = "Alan";
		String lastName = "Turing";

		EncryptedString pwd = new EncryptedString("pwd");

		User userObject = new User(firstName, lastName);

		SecurityContext ctx = new SecurityContext(userObject);

		try {
			ctx.login(pwd);
			assertTrue(ctx.getState() instanceof LoggedIn);
			ctx.logout();
			assertFalse(ctx.getState() instanceof LoggedIn);
			ctx.login(pwd);
			assertTrue(ctx.getState() instanceof LoggedIn);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Test
	public void multipleUserSessions() {
		String firstName = "Alan";
		String lastName = "Turing";

		EncryptedString pwd = new EncryptedString("pwd");

		User userObject = new User(firstName, lastName);
		SecurityContext ctx = new SecurityContext(userObject);


		String firstName1 = "Dennis";
		String lastName1 = "Ritchie";

		EncryptedString pwd1 = new EncryptedString("pwd");

		User userObject1 = new User(firstName1, lastName1);
		SecurityContext ctx1 = new SecurityContext(userObject1);

		try {
			ctx.login(pwd);
			assertTrue(ctx.getState() instanceof LoggedIn);

			// Checking if user2 is logged out
			assertTrue(ctx1.getState() instanceof LoggedOut);

			ctx1.login(pwd1);
			assertTrue(ctx1.getState() instanceof LoggedIn);

			ctx1.logout();
			assertTrue(ctx1.getState() instanceof LoggedOut);
			assertTrue(ctx.getState() instanceof LoggedIn);

			ctx.logout();
			assertFalse(ctx.getState() instanceof LoggedIn);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
