package edu.umb.cs680.hw05;

import javax.security.sasl.AuthenticationException;

public class LoggedOut implements State {

	private LoggedOut() {

	}

	private static LoggedOut loggedOutInstance = null;

	public static LoggedOut loggedOutState() {
		if (loggedOutInstance == null) {
			loggedOutInstance = new LoggedOut();
		}

		return loggedOutInstance;
	}

	@Override
	public void login(EncryptedString pwd, SecurityContext ctx, User user) throws AuthenticationException {
		if (Authenticator.authenticate(user,pwd)) {
			ctx.changeState(LoggedIn.loggedInState());
		} else {
			throw new AuthenticationException("Invalid login");
		}
	}

	@Override
	public void logout(SecurityContext ctx) {
		System.out.println("You have been logged out!");
	}
}
