package edu.umb.cs680.hw13.fs.util;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.ArrayList;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import edu.umb.cs680.hw13.fs.Directory;
import edu.umb.cs680.hw13.fs.FileSystem;
import edu.umb.cs680.hw13.fs.Fixture;

public class FileCrawlingVisitorTest {
	private static FileSystem fs;

	@BeforeAll
	public static void setUpFs() {
		fs = Fixture.createFs();
	}

	@Test
	public void crawlFiles() {
		Directory rootDir = fs.getRootDirs().getFirst();

		FileCrawlingVisitor visitor = new FileCrawlingVisitor();

		rootDir.accept(visitor);

		String[] expectedFiles = {"x", "y", "a", "b", "c"};

		ArrayList<String> actualFiles = new ArrayList<>();

		for (int i = 0;i < visitor.getFiles().size();i ++) {
			actualFiles.add(visitor.getFiles().get(i).getName());
		}

		assertArrayEquals(expectedFiles, actualFiles.toArray());
	}

	@AfterAll
	public static void cleanUp() {
		fs.getRootDirs().clear();
	}
}
