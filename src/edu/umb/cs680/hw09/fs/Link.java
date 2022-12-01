package edu.umb.cs680.hw09.fs;

import edu.umb.cs680.hw09.fs.util.FSVisitor;

public class Link extends FSElement{
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
	public void accept(FSVisitor v) {
		v.visit(this);
		
	}
}
