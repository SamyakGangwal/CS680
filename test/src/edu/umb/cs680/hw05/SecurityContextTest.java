package edu.umb.cs680.hw05;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SecurityContextTest {
	private User userinfo;
	private SecurityContext ctx;
	private EncryptedString pwd;

	@BeforeEach
	void setUp() {
		this.userinfo = new User("Alan", "Turing");
		this.pwd = new EncryptedString("pwd");
		this.ctx = new SecurityContext(this.userinfo);
	}

	@Test
	public void loginTrue() throws Exception {

		ctx.login(pwd);
		assertTrue(ctx.getState() instanceof LoggedIn);

	}

	@Test
	public void loginFalse() throws Exception {

		ctx.logout();
		assertFalse(ctx.getState() instanceof LoggedIn);

	}

	@Test
	public void loginLogoutLogin() throws Exception {

		ctx.login(pwd);
		assertTrue(ctx.getState() instanceof LoggedIn);
		ctx.logout();
		assertFalse(ctx.getState() instanceof LoggedIn);
		ctx.login(pwd);
		assertTrue(ctx.getState() instanceof LoggedIn);

	}

	@Test
	public void multipleUserSessions() throws Exception {
		EncryptedString pwd1 = new EncryptedString("pwd");

		User userObject1 = new User("Dennis", "Ritchie");
		SecurityContext ctx1 = new SecurityContext(userObject1);

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
	}

	@Test
	public void checkActiveLoginSession() throws Exception {
		ctx.login(pwd);
		assertTrue(ctx.isActive());

	}

}
