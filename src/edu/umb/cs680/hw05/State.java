package edu.umb.cs680.hw05;

import javax.security.sasl.AuthenticationException;

public interface State {
	public void login(EncryptedString pwd, SecurityContext ctx, User user) throws AuthenticationException;

	public void logout(SecurityContext ctx);
}
