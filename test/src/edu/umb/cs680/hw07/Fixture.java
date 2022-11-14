package edu.umb.cs680.hw07;

public class Fixture {
	public static FileSystem createFs() {
		FileSystem fs = FileSystem.getFileSystem();

		Directory root = new Directory(null, "root");

		fs.appendRootDir(root);

		Directory app = new Directory(root, "apps");

		Directory lib = new Directory(root, "lib");

		Directory home = new Directory(root, "home");

		File x = new File(app, "x", 100);

		File y = new File(app, "y", 100);

		File z = new File(lib, "z", 100);

		Directory code = new Directory(home, "code");

		File d = new File(home, "d", 100);

		File a = new File(code, "a", 100);

		File b = new File(code, "b", 100);

		File c = new File(code, "c", 100);

		return fs;
	}
}
