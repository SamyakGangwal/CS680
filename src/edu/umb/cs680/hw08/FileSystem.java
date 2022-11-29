package edu.umb.cs680.hw08;

import java.util.LinkedList;

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
		
		System.out.println(fs.getRootDirs().getFirst().getName());
	}
}
