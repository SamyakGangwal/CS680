package edu.umb.cs680.hw09.fs;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.LinkedList;

import org.junit.jupiter.api.*;

public class DirectoryTest {
	private static FileSystem fs;

	@BeforeAll
	public static void setUpFs() {
		fs = Fixture.createFs();
	}

	@Test
	public void verifygetChildren() {
		Directory rootdir = fs.getRootDirs().getFirst();

		ArrayList<String> expected = new ArrayList<>();

		expected.add("apps");
		expected.add("bin");
		expected.add("home");
		expected.add("d");
		expected.add("e");

		LinkedList<FSElement> actual = rootdir.getChildren();

		ArrayList<String> actualList = new ArrayList<>();

		for (int i = 0; i < actual.size(); i++) {
			actualList.add(actual.get(i).getName());
		}

		assertArrayEquals(expected.toArray(), actualList.toArray());
	}

	@Test
	public void verifyGetName() {
		Directory rootdir = fs.getRootDirs().getFirst();

		assertEquals("root", rootdir.getName());
	}

	@Test
	public void verifyGetSize() {
		Directory rootdir = fs.getRootDirs().getFirst();

		assertEquals(0, rootdir.getSize());
	}

	@Test
	public void verifyGetParent() {
		LinkedList<FSElement> rootChildren = fs.getRootDirs().getFirst().getChildren();

		Directory app = (Directory) rootChildren.getFirst();

		assertEquals("root", app.getParent().getName());

	}

	@Test
	public void verifyChildrenCount() {
		Directory root = fs.getRootDirs().getFirst();

		assertEquals(5, root.countChildren());
	}

	@Test
	public void verifyGetSubChildren() {
		String[] subChildren = {"apps", "bin", "home"};

		Directory root = fs.getRootDirs().getFirst();

		String[] actualSubDirectories = new String[root.getSubDirectories().size()];

		for (int i = 0; i < root.getSubDirectories().size(); i++) {
			actualSubDirectories[i] = root.getSubDirectories().get(i).getName();
		}



		assertArrayEquals(subChildren, actualSubDirectories);
	}

	@Test
	public void verifyGetFile() {
		Directory root = fs.getRootDirs().getFirst();

		Directory apps = root.getSubDirectories().getFirst();

		String filename = "x";

		String actual = apps.getFiles().get(0).getName();

		assertEquals(filename, actual);
	}

	@Test
	public void verifyTotalSize() {
		Directory root = fs.getRootDirs().getFirst();

		assertEquals(500, root.getTotalSize());
	}

	@Test
	public void DirectorySizeZero() {
		Directory root = fs.getRootDirs().getFirst();

		assertEquals(0, root.getSize());
	}

	@AfterAll
	public static void cleanUp() {
		fs.getRootDirs().clear();
	}
}
