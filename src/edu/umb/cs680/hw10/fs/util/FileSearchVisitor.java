package edu.umb.cs680.hw10.fs.util;

import java.util.LinkedList;
import edu.umb.cs680.hw10.fs.Directory;
import edu.umb.cs680.hw10.fs.File;
import edu.umb.cs680.hw10.fs.Link;

public class FileSearchVisitor implements FSVisitor {
	private String fileName;
	private LinkedList<File> foundFiles = new LinkedList<>();


	public FileSearchVisitor(String fileName) {
		this.fileName = fileName;
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
		if (file.getName().equals(fileName)) {
			foundFiles.add(file);
		}	
	}

	public LinkedList<File> getFoundFiles() {
		return foundFiles;
	}

}
