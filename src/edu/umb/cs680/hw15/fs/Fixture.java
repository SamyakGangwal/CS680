package edu.umb.cs680.hw15.fs;

public class Fixture {
	public static FileSystem createFs() throws InterruptedException {
		FileSystem fs = FileSystem.getFileSystem();

		Directory root = new Directory(null, "root");

		Thread.sleep(1000);

		fs.appendRootDir(root);

		Directory app = new Directory(root, "apps");
		Thread.sleep(10);

		Directory bin = new Directory(root, "bin");
		Thread.sleep(10);

		Directory home = new Directory(root, "home");
		Thread.sleep(10);

		Directory pictures = new Directory(home, "pictures");

		File a = new File(pictures, "a", 100);

		File b = new File(pictures, "b", 100);

		File c = new File(home, "c", 100);

		File x = new File(app, "x", 100);

		File y = new File(bin, "y", 100);
		
		Link d = new Link(root, "d", pictures);

		Link e = new Link(root, "e", x);

		

		return fs;
	}
}
