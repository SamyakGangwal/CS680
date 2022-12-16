package edu.umb.cs680.hw13.fs.util;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import edu.umb.cs680.hw13.fs.Directory;
import edu.umb.cs680.hw13.fs.FileSystem;
import edu.umb.cs680.hw13.fs.Fixture;

public class FileSearchVisitorTest {
	private static FileSystem fs;

	@BeforeAll
	public static void setUpFs() {
		fs = Fixture.createFs();
	}

	@Test
	public void oneFileFound() {
		Directory rootDir = fs.getRootDirs().getFirst();
		FileSearchVisitor visitor = new FileSearchVisitor("y");
		rootDir.accept(visitor);
		assertEquals("y", visitor.getFoundFiles().getFirst().getName());
	}

	@Test
	public void noFileFound() {
		Directory rootDir = fs.getRootDirs().getFirst();
		FileSearchVisitor visitor = new FileSearchVisitor("xyz");
		rootDir.accept(visitor);
		assertEquals(0, visitor.getFoundFiles().size());
	}

	@AfterAll
	public static void cleanUp() {
		fs.getRootDirs().clear();
	}
}
