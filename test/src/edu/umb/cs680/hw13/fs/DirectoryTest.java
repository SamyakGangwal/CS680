package edu.umb.cs680.hw13.fs;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.LinkedList;

import org.junit.jupiter.api.*;

public class DirectoryTest {
	private static FileSystem fs;

	@BeforeAll
	public static void setUpFs() throws InterruptedException {
		fs = Fixture.createFs();
	}

	@Test
	public void verifygetChildren() {
		Directory rootdir = fs.getRootDirs().getFirst();

		ArrayList<String> expected = new ArrayList<>();

		expected.add("apps");
		expected.add("bin");
		expected.add("d");
		expected.add("e");
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

	@Test
	public void getChildrenAlphabet() {
		Directory rootdir = fs.getRootDirs().getFirst();

		ArrayList<String> expected = new ArrayList<>();

		expected.add("apps");
		expected.add("bin");
		expected.add("d");
		expected.add("e");
		expected.add("home");

		LinkedList<FSElement> actual = rootdir.getChildren(new AlphabeticalComparator());

		ArrayList<String> actualList = new ArrayList<>();

		for (int i = 0; i < actual.size(); i++) {
			actualList.add(actual.get(i).getName());
		}

		assertArrayEquals(expected.toArray(), actualList.toArray());
	}

	@Test
	public void getChildrenReverseAlphabet() {
		Directory rootdir = fs.getRootDirs().getFirst();

		ArrayList<String> expected = new ArrayList<>();

		expected.add("home");
		expected.add("e");
		expected.add("d");
		expected.add("bin");
		expected.add("apps");

		LinkedList<FSElement> actual = rootdir.getChildren(new ReverseAlphabeticalComparator());

		ArrayList<String> actualList = new ArrayList<>();

		for (int i = 0; i < actual.size(); i++) {
			actualList.add(actual.get(i).getName());
		}

		assertArrayEquals(expected.toArray(), actualList.toArray());
	}

	@Test
	public void getChildrenSize() {
		Directory rootdir = fs.getRootDirs().getFirst();

		ArrayList<String> expected = new ArrayList<>();

		expected.add("apps");
		expected.add("bin");
		expected.add("d");
		expected.add("e");
		expected.add("home");

		LinkedList<FSElement> actual = rootdir.getChildren(new SizeComparator());

		ArrayList<String> actualList = new ArrayList<>();

		for (int i = 0; i < actual.size(); i++) {
			actualList.add(actual.get(i).getName());
		}

		assertArrayEquals(expected.toArray(), actualList.toArray());
	}

	@Test
	public void getChildrenTime() {
		Directory rootdir = fs.getRootDirs().getFirst();

		ArrayList<String> expected = new ArrayList<>();

		expected.add("apps");
		expected.add("bin");
		expected.add("home");
		expected.add("d");
		expected.add("e");

		LinkedList<FSElement> actual = rootdir.getChildren(new TimeStampComparator());

		ArrayList<String> actualList = new ArrayList<>();

		for (int i = 0; i < actual.size(); i++) {
			actualList.add(actual.get(i).getName());
		}

		assertArrayEquals(expected.toArray(), actualList.toArray());
	}

	@Test
	public void getSubDirectoriesAlphabet() {
		String[] subChildren = {"apps", "bin", "home"};

		Directory root = fs.getRootDirs().getFirst();

		String[] actualSubDirectories = new String[root.getSubDirectories().size()];

		for (int i = 0; i < root.getSubDirectories().size(); i++) {
			actualSubDirectories[i] = root.getSubDirectories(new AlphabeticalComparator()).get(i).getName();
		}

		assertArrayEquals(subChildren, actualSubDirectories);
	}

	@Test
	public void getSubDirectoriesReverseAlphabet() {
		String[] subChildren = {"home", "bin", "apps"};

		Directory root = fs.getRootDirs().getFirst();

		String[] actualSubDirectories = new String[root.getSubDirectories().size()];

		for (int i = 0; i < root.getSubDirectories().size(); i++) {
			actualSubDirectories[i] = root.getSubDirectories(new ReverseAlphabeticalComparator()).get(i).getName();
		}

		assertArrayEquals(subChildren, actualSubDirectories);
	}

	@Test
	public void getSubDirectoriesSize() {
		String[] subChildren = {"home", "bin", "apps"};

		Directory root = fs.getRootDirs().getFirst();

		String[] actualSubDirectories = new String[root.getSubDirectories().size()];

		for (int i = 0; i < root.getSubDirectories().size(); i++) {
			actualSubDirectories[i] = root.getSubDirectories(new SizeComparator()).get(i).getName();
		}

		assertArrayEquals(subChildren, actualSubDirectories);
	}

	@Test
	public void getSubDirectoriesTime() {
		String[] subChildren = { "apps", "bin", "home"};

		Directory root = fs.getRootDirs().getFirst();

		String[] actualSubDirectories = new String[root.getSubDirectories().size()];

		for (int i = 0; i < root.getSubDirectories().size(); i++) {
			actualSubDirectories[i] = root.getSubDirectories(new TimeStampComparator()).get(i).getName();
		}

		assertArrayEquals(subChildren, actualSubDirectories);
	}

	@Test
	public void getFilesAlphabet() {
		Directory root = fs.getRootDirs().getFirst();

		Directory apps = root.getSubDirectories().getFirst();

		String filename = "x";

		String actual = apps.getFiles(new AlphabeticalComparator()).get(0).getName();

		assertEquals(filename, actual);
	}

	@Test
	public void getFilesReverseAlphabet() {
		Directory root = fs.getRootDirs().getFirst();

		Directory apps = root.getSubDirectories().getFirst();

		String filename = "x";

		String actual = apps.getFiles(new ReverseAlphabeticalComparator()).get(0).getName();

		assertEquals(filename, actual);
	}

	@Test
	public void getFilesSize() {
		Directory root = fs.getRootDirs().getFirst();

		Directory apps = root.getSubDirectories().getFirst();

		String filename = "x";

		String actual = apps.getFiles(new SizeComparator()).get(0).getName();

		assertEquals(filename, actual);
	}

	@Test
	public void getFilesTime() {
		Directory root = fs.getRootDirs().getFirst();

		Directory apps = root.getSubDirectories().getFirst();

		String filename = "x";

		String actual = apps.getFiles(new TimeStampComparator()).get(0).getName();

		assertEquals(filename, actual);
	}

	@AfterAll
	public static void cleanUp() {
		fs.getRootDirs().clear();
	}
}
