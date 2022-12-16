package edu.umb.cs680.hw10.fs.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import edu.umb.cs680.hw10.fs.Directory;
import edu.umb.cs680.hw10.fs.EncryptedString;
import edu.umb.cs680.hw10.fs.FileSystem;
import edu.umb.cs680.hw10.fs.Fixture;
import edu.umb.cs680.hw10.fs.SecurityContext;
import edu.umb.cs680.hw10.fs.User;

public class CountingVisitorTest {
	private static FileSystem fs;

	@BeforeAll
	public static void setUpFs() {
		fs = Fixture.createFs();
	}

	@Test
	public void getTotalDirs() {
		Directory rootDir = fs.getRootDirs().getFirst();

		String firstName = "mark";
		String lastName = "hamill";

		EncryptedString pwd = new EncryptedString("starwars");

		User userObject = new User(firstName, lastName, pwd);

		SecurityContext ctx = new SecurityContext(userObject);

		try {
			ctx.login(pwd, userObject);

			CountingVisitor visitor = new CountingVisitor();
			rootDir.accept(visitor, ctx);
			assertEquals(5, visitor.getDirNum());

			ctx.logout();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	@Test
	public void getTotalFiles() {
		String firstName = "mark";
		String lastName = "hamill";

		EncryptedString pwd = new EncryptedString("starwars");

		User userObject = new User(firstName, lastName, pwd);

		SecurityContext ctx = new SecurityContext(userObject);
		try {
			ctx.login(pwd, userObject);
			Directory rootDir = fs.getRootDirs().getFirst();

			CountingVisitor visitor = new CountingVisitor();
			rootDir.accept(visitor, ctx);
			assertEquals(5, visitor.getFileNum());
			ctx.logout();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Test
	public void getTotalLinks() {
		String firstName = "mark";
		String lastName = "hamill";

		EncryptedString pwd = new EncryptedString("starwars");

		User userObject = new User(firstName, lastName, pwd);

		SecurityContext ctx = new SecurityContext(userObject);
		try {
			ctx.login(pwd, userObject);
			Directory rootDir = fs.getRootDirs().getFirst();

			CountingVisitor visitor = new CountingVisitor();
			rootDir.accept(visitor, ctx);
			assertEquals(2, visitor.getLinkNum());
			ctx.logout();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Test
	public void getTotalLinksloggedOut() {
		String firstName = "mark";
		String lastName = "hamill";

		EncryptedString pwd = new EncryptedString("starwars");

		User userObject = new User(firstName, lastName, pwd);

		SecurityContext ctx = new SecurityContext(userObject);
		try {
			ctx.login(pwd, userObject);
			ctx.logout();
			Directory rootDir = fs.getRootDirs().getFirst();

			CountingVisitor visitor = new CountingVisitor();
			rootDir.accept(visitor, ctx);

			assertFalse(true);


		} catch (Exception e) {
			String expected = "Invalid login";

			assertEquals(expected, e.getMessage());
		}
	}

	@AfterAll
	public static void cleanUp() {
		fs.getRootDirs().clear();
	}
}
