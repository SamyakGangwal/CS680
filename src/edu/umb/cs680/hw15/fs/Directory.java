package edu.umb.cs680.hw15.fs;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public class Directory extends FSElement {
	LinkedList<FSElement> children = new LinkedList<>();

	public Directory(Directory parent, String name) {
		super(parent, name, 0);
	}

	public LinkedList<FSElement> getChildren() {
		LinkedList<FSElement> children = this.children;
		Collections.sort(children, (FSElement fs1, FSElement fs2) -> {
			return fs1.getName().compareTo(fs2.getName());
		});
		return children;
	}

	public void appendChild(FSElement child) {
		this.children.add(child);
	}

	public int countChildren() {
		return children.size();
	}

	public LinkedList<Directory> getSubDirectories() {
		LinkedList<Directory> subDirectories = new LinkedList<>();

		for (int i = 0; i < children.size(); i++) {
			if (children.get(i).isDirectory()) {
				subDirectories.add((Directory) children.get(i));
			}
		}

		Collections.sort(subDirectories, (FSElement fs1, FSElement fs2) -> {
			return fs1.getName().compareTo(fs2.getName());
		});

		return subDirectories;
	}

	public LinkedList<File> getFiles() {
		LinkedList<File> files = new LinkedList<>();

		for (int i = 0; i < this.children.size(); i++) {
			if (!children.get(i).isDirectory()) {
				files.add((File) children.get(i));
			}
		}

		Collections.sort(files, (FSElement fs1, FSElement fs2) -> {
			return fs1.getName().compareTo(fs2.getName());
		});

		return files;
	}

	public int getTotalSize() {
		int totalSize = 0;

		for (int i = 0; i < this.children.size(); i++) {
			if (!this.children.get(i).isDirectory()) {
				totalSize += this.children.get(i).getSize();
			} else {
				Directory dir = (Directory) this.children.get(i);
				totalSize += dir.getTotalSize();
			}
		}

		return totalSize;
	}

	@Override
	public boolean isDirectory() {
		return true;
	}

	@Override
	public void accept(FSVisitor v) {
		v.visit(this);

		for (FSElement e : children) {
			e.accept(v);
		}

	}

	public LinkedList<Directory> getSubDirectories(Comparator<FSElement> c) {
		LinkedList<Directory> subDirectories = new LinkedList<>();

		for (int i = 0; i < children.size(); i++) {
			if (children.get(i).isDirectory()) {
				subDirectories.add((Directory) children.get(i));
			}
		}

		Collections.sort(subDirectories, c);

		return subDirectories;
	}

	public LinkedList<File> getFiles(Comparator<FSElement> c) {
		LinkedList<File> files = new LinkedList<>();

		for (int i = 0; i < this.children.size(); i++) {
			if (!children.get(i).isDirectory()) {
				files.add((File) children.get(i));
			}
		}

		Collections.sort(files, c);

		return files;
	}

	public LinkedList<FSElement> getChildren(Comparator<FSElement> c) {

		LinkedList<FSElement> children = this.children;

		Collections.sort(children, c);

		return children;
	}

}
