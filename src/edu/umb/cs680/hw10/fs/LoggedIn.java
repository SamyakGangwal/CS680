package edu.umb.cs680.hw10.fs;

import javax.security.sasl.AuthenticationException;

public class LoggedIn implements State {

	private LoggedIn() {
	}

	private static LoggedIn loggedInInstance = null;

	public static LoggedIn loggedInState() {
		if (loggedInInstance == null) {
			loggedInInstance = new LoggedIn();
		}

		return loggedInInstance;
	}

	@Override
	public void login(EncryptedString pwd, SecurityContext ctx, User user) throws AuthenticationException {
		if (!ctx.isActive()) {
			ctx.logout();
			ctx.login(pwd, user);
		}
	}

	@Override
	public void logout(SecurityContext ctx) {
		ctx.changeState(LoggedOut.loggedOutState());
	}

}
