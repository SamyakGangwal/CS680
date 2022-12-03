package edu.umb.cs680.hw10.fs;

import java.util.LinkedList;
import edu.umb.cs680.hw10.fs.util.CountingVisitor;
import edu.umb.cs680.hw10.fs.util.FileCrawlingVisitor;
import edu.umb.cs680.hw10.fs.util.FileSearchVisitor;

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
		String firstName = "mark";
		String lastName = "hamill";

		EncryptedString pwd = new EncryptedString("starwars");

		User userObject = new User(firstName, lastName, pwd);

		SecurityContext ctx = new SecurityContext(userObject);

		FileSystem fs = Fixture.createFs();

		System.out.println("The root folder is:");

		Directory rootDir = fs.getRootDirs().getFirst();

		System.out.println(rootDir.getName());

		try {
			ctx.login(pwd, userObject);
			System.out.println(ctx.getState() instanceof LoggedIn);

			FileSearchVisitor visitor = new FileSearchVisitor("x");
			rootDir.accept(visitor, ctx);
			System.out.println("Number of files: " + visitor.getFoundFiles().size());

			FileCrawlingVisitor visitor2 = new FileCrawlingVisitor();
			rootDir.accept(visitor2, ctx);
			visitor2.getFiles();

			CountingVisitor visitor3 = new CountingVisitor();
			rootDir.accept(visitor3, ctx);
			visitor3.getDirNum();
			visitor3.getFileNum();
			visitor3.getLinkNum();

			ctx.logout();
			System.out.println(ctx.getState() instanceof LoggedOut);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}
}
