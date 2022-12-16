package edu.umb.cs680.hw15.fs;

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
