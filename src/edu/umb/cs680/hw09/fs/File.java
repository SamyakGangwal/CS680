package edu.umb.cs680.hw09.fs;

import edu.umb.cs680.hw09.fs.util.FSVisitor;

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
