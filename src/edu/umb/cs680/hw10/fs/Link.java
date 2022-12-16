package edu.umb.cs680.hw10.fs;

import javax.security.sasl.AuthenticationException;

public class Link extends FSElement {
	private FSElement target;

	public Link(Directory parent, String name, FSElement target) {
		super(parent, name, 0);
		this.target = target;
	}

	public FSElement getTarget() {
		return target;
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
