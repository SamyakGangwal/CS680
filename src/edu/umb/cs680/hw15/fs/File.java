package edu.umb.cs680.hw15.fs;

public class File extends FSElement {
	public File(Directory parent, String name, int size) {
		super(parent, name, size);
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
