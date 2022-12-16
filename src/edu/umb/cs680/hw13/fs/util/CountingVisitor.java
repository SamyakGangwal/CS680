package edu.umb.cs680.hw13.fs.util;

import edu.umb.cs680.hw13.fs.Directory;
import edu.umb.cs680.hw13.fs.FSVisitor;
import edu.umb.cs680.hw13.fs.File;
import edu.umb.cs680.hw13.fs.Link;

public class CountingVisitor implements FSVisitor {
	private int dirNum;
	private int fileNum;
	private int linkNum;

	public CountingVisitor() {
		this.dirNum = 0;
		this.fileNum = 0;
		this.linkNum = 0;
	}

	@Override
	public void visit(Link link) {
		this.linkNum ++;
	}

	@Override
	public void visit(Directory dir) {
		this.dirNum ++;
	}

	@Override
	public void visit(File file) {
		this.fileNum ++;
	}

	public int getDirNum() {
		return dirNum;
	}

	public int getFileNum() {
		return fileNum;
	}

	public int getLinkNum() {
		return linkNum;
	}
}
