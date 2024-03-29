package edu.umb.cs680.hw07;

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
		expected.add("lib");
		expected.add("home");

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

		assertEquals(3, root.countChildren());
	}

	@Test
	public void verifyGetSubChildren() {
		String[] subChildren = { "apps", "lib", "home" };

		Directory root = fs.getRootDirs().getFirst();

		String[] actualSubDirectories = new String[root.getSubDirectories().size()];

		for (int i = 0;i < root.getSubDirectories().size();i ++) {
			actualSubDirectories[i] = root.getSubDirectories().get(i).getName();
		}



		assertArrayEquals(subChildren, actualSubDirectories);
	}

	@Test
	public void verifyGetFile() {
		Directory root = fs.getRootDirs().getFirst();

		Directory apps = root.getSubDirectories().getFirst();

		String[] fileList = {"x", "y"};

		String[] actual = new String[2];

		for (int i = 0;i < 2;i ++) {
			actual[i] = apps.getFiles().get(i).getName();
		}

		assertArrayEquals(fileList, actual);
	}

	@Test
	public void verifyTotalSize() {
		Directory root = fs.getRootDirs().getFirst();

		assertEquals(700, root.getTotalSize());
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