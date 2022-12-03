package edu.umb.cs680.hw10.fs.util;

import edu.umb.cs680.hw10.fs.Directory;
import edu.umb.cs680.hw10.fs.File;
import edu.umb.cs680.hw10.fs.Link;

public interface FSVisitor {
	public void visit(Link link);
	public void visit(Directory dir);
	public void visit(File file);
}
