package edu.umb.cs680.hw10.fs.util;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.ArrayList;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import edu.umb.cs680.hw10.fs.Directory;
import edu.umb.cs680.hw10.fs.EncryptedString;
import edu.umb.cs680.hw10.fs.FileSystem;
import edu.umb.cs680.hw10.fs.Fixture;
import edu.umb.cs680.hw10.fs.SecurityContext;
import edu.umb.cs680.hw10.fs.User;

public class FileCrawlingVisitorTest {
	private static FileSystem fs;

	@BeforeAll
	public static void setUpFs() {
		fs = Fixture.createFs();
	}

	@Test
	public void crawlFiles() {
		String firstName = "mark";
		String lastName = "hamill";

		EncryptedString pwd = new EncryptedString("starwars");

		User userObject = new User(firstName, lastName, pwd);

		SecurityContext ctx = new SecurityContext(userObject);
		try {
			ctx.login(pwd, userObject);
			Directory rootDir = fs.getRootDirs().getFirst();
			FileCrawlingVisitor visitor = new FileCrawlingVisitor();

			rootDir.accept(visitor, ctx);

			String[] expectedFiles = {"x", "y", "a", "b", "c"};

			ArrayList<String> actualFiles = new ArrayList<>();

			for (int i = 0; i < visitor.getFiles().size(); i++) {
				actualFiles.add(visitor.getFiles().get(i).getName());
			}

			assertArrayEquals(expectedFiles, actualFiles.toArray());
			ctx.logout();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Test
	public void crawlFilesLoggedOut() {
		String firstName = "mark";
		String lastName = "hamill";

		EncryptedString pwd = new EncryptedString("starwars");

		User userObject = new User(firstName, lastName, pwd);

		SecurityContext ctx = new SecurityContext(userObject);
		try {
			ctx.login(pwd, userObject);
			ctx.logout();
			Directory rootDir = fs.getRootDirs().getFirst();
			FileCrawlingVisitor visitor = new FileCrawlingVisitor();

			rootDir.accept(visitor, ctx);

			String[] expectedFiles = {"x", "y", "a", "b", "c"};

			ArrayList<String> actualFiles = new ArrayList<>();

			for (int i = 0; i < visitor.getFiles().size(); i++) {
				actualFiles.add(visitor.getFiles().get(i).getName());
			}

			assertArrayEquals(expectedFiles, actualFiles.toArray());


		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@AfterAll
	public static void cleanUp() {
		fs.getRootDirs().clear();
	}
}
