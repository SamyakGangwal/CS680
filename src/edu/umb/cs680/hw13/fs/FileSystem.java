package edu.umb.cs680.hw13.fs;

import java.util.LinkedList;
import edu.umb.cs680.hw13.fs.util.CountingVisitor;
import edu.umb.cs680.hw13.fs.util.FileCrawlingVisitor;
import edu.umb.cs680.hw13.fs.util.FileSearchVisitor;

public class FileSystem {
	private LinkedList<Directory> rootDirs = new LinkedList<>();

	private FileSystem() {

	}

	private static FileSystem fsInstance = null;

	public static FileSystem getFileSystem() {
		if (fsInstance == null) {
			fsInstance = new FileSystem();
		}

		return fsInstance;
	}

	public LinkedList<Directory> getRootDirs() {
		return this.rootDirs;
	}

	public void appendRootDir(Directory root) {
		this.rootDirs.add(root);
	}

	public static void main(String[] args) {
		FileSystem fs = Fixture.createFs();

		System.out.println("The root folder is:");

		Directory rootDir = fs.getRootDirs().getFirst();

		System.out.println(rootDir.getName());

		FileSearchVisitor visitor = new FileSearchVisitor("x");
		rootDir.accept(visitor);
		System.out.println("Number of files: " + visitor.getFoundFiles().size());

		FileCrawlingVisitor visitor2 = new FileCrawlingVisitor();
		rootDir.accept(visitor2);
		visitor2.getFiles();

		CountingVisitor visitor3 = new CountingVisitor();
		rootDir.accept(visitor3);
		visitor3.getDirNum();
		visitor3.getFileNum();
		visitor3.getLinkNum();

	}
}
