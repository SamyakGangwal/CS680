package edu.umb.cs680.hw13.fs;

import static org.junit.jupiter.api.Assertions.*;

import java.util.LinkedList;

import org.junit.jupiter.api.*;

public class LinkTest {
	private static FileSystem fs;

	@BeforeAll
	public static void setUpFs() {
		fs = Fixture.createFs();
	}

	@Test
	public void getLinks() {
		Directory root = fs.getRootDirs().getFirst();

		LinkedList<FSElement> FsElementList = root.getChildren();

		Link d = new Link(null, null, null);

		for (int i = 0;i < FsElementList.size();i ++) {
			if (FsElementList.get(i).getName().equals("d")) {
				d = (Link) FsElementList.get(i);
			}
		}

		assertEquals("pictures", d.getTarget().getName());

		Link e = new Link(null, null, null);

		for (int i = 0;i < FsElementList.size();i ++) {
			if (FsElementList.get(i).getName().equals("e")) {
				e = (Link) FsElementList.get(i);
			}
		}

		assertEquals("x", e.getTarget().getName());
	}

	@AfterAll
	public static void cleanUp() {
		fs.getRootDirs().clear();
	}
}
