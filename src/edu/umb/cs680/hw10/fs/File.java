package edu.umb.cs680.hw10.fs;

import javax.security.sasl.AuthenticationException;

public class File extends FSElement {
	public File(Directory parent, String name, int size) {
		super(parent, name, size);
	}

	@Override
	public boolean isDirectory() {
		return false;
	}

	@Override
	public void accept(FSVisitor v, SecurityContext ctx) throws AuthenticationException {
		if (ctx.isActive()) {
			v.visit(this);
		} else {
			throw new AuthenticationException("Invalid login");
		}

	}

}
