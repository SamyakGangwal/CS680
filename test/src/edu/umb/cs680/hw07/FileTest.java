package edu.umb.cs680.hw07;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
		Directory lib = (Directory)fs.getRootDirs().get(0).getChildren().get(1);

		String z = lib.getChildren().get(0).getName();

		assertEquals("z", z);
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

		File z = (File)lib.getChildren().getFirst();

		String parent = z.getParent().getName();

		assertEquals("lib", parent);
	}
}
