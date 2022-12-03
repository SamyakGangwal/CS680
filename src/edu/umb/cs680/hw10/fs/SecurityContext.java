package edu.umb.cs680.hw10.fs;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.LinkedList;

import javax.security.sasl.AuthenticationException;

public class SecurityContext {
	private User user;

	private State state;

	public State getState() {
		return state;
	}

	private LinkedList<LocalDateTime> last_login = new LinkedList<>();

	public User getUser() {
		return user;
	}

	public SecurityContext(User user) {
		this.user = user;
		this.state = LoggedOut.loggedOutState();
	}

	public void changeState(State newState) {
		state = newState;
	}

	public void login(EncryptedString pwd, User user) throws AuthenticationException {
		state.login(pwd, this, user);
		last_login.addFirst(LocalDateTime.now());
	}

	public void logout() {
		this.state.logout(this);
	}

	public boolean isActive() {
		if (this.last_login.isEmpty()) {
			return false;
		}

		int lastActivity = Duration.between(
			LocalDateTime.now(), 
			this.last_login.getFirst())
			.compareTo(
				Duration.ofMinutes(3)
			);

		if (this.state instanceof LoggedIn && lastActivity < 0) {
			return true;
		}

		return false;
	}
}
