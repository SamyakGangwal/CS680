package edu.umb.cs680.hw06.modelxyz;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import edu.umb.cs680.hw06.printingframework.PrintJob;

public class PrintJobExecuterTest {

	@Test
	public void printInModelXYZ() {
		String expected = "TEST";
		PrintJob job = new PrintJob(expected);

		PrintJobExecutor xyz = new PrintJobExecutor();

		assertTrue(xyz.execute(job, null, null, null));
	}

	@Test
	public void multiplePrint() {
		String[] expected = { "TEST", "TEST1" };

		PrintJob job = new PrintJob(expected[0]);

		job.addPrintJob(expected[1]);

		for (int i = 0; i < expected.length; i++) {
			PrintJobExecutor xyz = new PrintJobExecutor();

			assertTrue(xyz.execute(job, null, null, null));
		}
	}
}
