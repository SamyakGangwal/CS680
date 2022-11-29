package edu.umb.cs680.hw07;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class FileSystemTest {
	private static FileSystem fs;

	@BeforeAll
	public static void setUpFs() {
		fs = Fixture.createFs();
	}

	@Test
	public void VerifyFileSystemInstanceNotNull() {
		assertNotEquals(null, fs);
	}

	@Test
	public void verifygetRootDirs() {
		String root = fs.getRootDirs().getFirst().getName();

		assertEquals("root", root);
	}

	@Test
	public void verifyAppendRootDir() {
		Directory root2 = new Directory(null, "root2");

		fs.appendRootDir(root2);

		String root2String= fs.getRootDirs().get(1).getName();

		assertEquals("root2", root2String);

	}

	@AfterAll
	public static void cleanUp() {
		fs.getRootDirs().clear();
	}
}
