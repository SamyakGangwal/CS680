package edu.umb.cs680.hw06.printingframework;

import java.util.LinkedList;
import java.util.Queue;

public class PrintJob {
	private Queue<String> printObjectString = new LinkedList<>();
	
	public PrintJob(String printObjectString) {
		this.printObjectString.add(printObjectString);
	}

	public void addPrintJob(String printObjectString) {
		this.printObjectString.add(printObjectString);
	}

	public String getFirstPrintJob() {
		return printObjectString.peek();
	}

	public String startPrintJob() {
		return printObjectString.remove();
	}
}
