package edu.umb.cs680.hw10.fs.util;

import java.util.LinkedList;
import edu.umb.cs680.hw10.fs.Directory;
import edu.umb.cs680.hw10.fs.FSVisitor;
import edu.umb.cs680.hw10.fs.File;
import edu.umb.cs680.hw10.fs.Link;

public class FileCrawlingVisitor implements FSVisitor {
	private LinkedList<File> files;

	public FileCrawlingVisitor() {
		this.files = new LinkedList<>();
	}


	@Override
	public void visit(Link link) {
		return;

	}

	@Override
	public void visit(Directory dir) {
		return;

	}

	@Override
	public void visit(File file) {
		files.add(file);

	}

	public LinkedList<File> getFiles() {
		return files;
	}

}
