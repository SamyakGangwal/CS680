package edu.umb.cs680.hw08;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class FileTest {
	private static FileSystem fs;

	@BeforeAll
	public static void setUpFs() {
		fs = Fixture.createFs();
	}

	@Test
	public void verifyGetName() {
		Directory bin = (Directory)fs.getRootDirs().get(0).getChildren().get(0);

		String x = bin.getChildren().get(0).getName();

		assertEquals("x", x);
	}

	@Test
	public void verifyGetSize() {
		Directory lib = (Directory)fs.getRootDirs().get(0).getChildren().get(1);

		int z = lib.getChildren().get(0).getSize();
	
		assertEquals(100, z);
	}

	@Test
	public void verifyGetParent() {
		Directory lib = (Directory)fs.getRootDirs().get(0).getChildren().get(1);

		File y = (File)lib.getChildren().getFirst();

		String parent = y.getParent().getName();

		assertEquals("bin", parent);
	}

	@AfterAll
	public static void cleanUp() {
		fs.getRootDirs().clear();
	}
}
