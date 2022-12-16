package edu.umb.cs680.hw13.fs.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import edu.umb.cs680.hw13.fs.Directory;
import edu.umb.cs680.hw13.fs.FileSystem;
import edu.umb.cs680.hw13.fs.Fixture;

public class CountingVisitorTest {
	private static FileSystem fs;

	@BeforeAll
	public static void setUpFs() {
		fs = Fixture.createFs();
	}

	@Test
	public void getTotalDirs() {
		Directory rootDir = fs.getRootDirs().getFirst();

		CountingVisitor visitor = new CountingVisitor();
		rootDir.accept(visitor);
		assertEquals(5, visitor.getDirNum());
	}

	@Test
	public void getTotalFiles() {
		Directory rootDir = fs.getRootDirs().getFirst();

		CountingVisitor visitor = new CountingVisitor();
		rootDir.accept(visitor);
		assertEquals(5, visitor.getFileNum());
	}

	@Test
	public void getTotalLinks() {
		Directory rootDir = fs.getRootDirs().getFirst();

		CountingVisitor visitor = new CountingVisitor();
		rootDir.accept(visitor);
		assertEquals(2, visitor.getLinkNum());
	}

	@AfterAll
	public static void cleanUp() {
		fs.getRootDirs().clear();
	}
}
