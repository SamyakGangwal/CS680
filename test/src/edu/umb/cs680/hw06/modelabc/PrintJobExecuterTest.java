package edu.umb.cs680.hw06.modelabc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.umb.cs680.hw05.EncryptedString;
import edu.umb.cs680.hw05.SecurityContext;
import edu.umb.cs680.hw05.User;
import edu.umb.cs680.hw06.printingframework.PrintJob;

public class PrintJobExecuterTest {
	private User userinfo;
	private SecurityContext ctx;
	private EncryptedString pwd;

	@BeforeEach
	void setup() {
		this.pwd = new EncryptedString("pwd");
		this.userinfo = new User("Alan", "Turing", this.pwd);
		this.ctx = new SecurityContext(this.userinfo);
	}

	@Test
	public void printInModelABC() {
		String expected = "TEST";
		PrintJob job = new PrintJob(expected);

		PrintJobExecutor xyz = new PrintJobExecutor();

		assertTrue(xyz.execute(job, pwd, ctx, userinfo));
	}

	@Test
	public void multiplePrint() {
		String[] expected = { "TEST", "TEST1" };

		PrintJob job = new PrintJob(expected[0]);

		job.addPrintJob(expected[1]);

		for (int i = 0; i < expected.length; i++) {
			PrintJobExecutor xyz = new PrintJobExecutor();

			assertTrue(xyz.execute(job, pwd, ctx, userinfo));
		}
	}

	@Test
	public void multiUserPrint() {
		EncryptedString pwd1 = new EncryptedString("pwd");
		User userinfo1 = new User("Alan", "Turing", pwd1);
		SecurityContext ctx1 = new SecurityContext(userinfo1);

		String expected = "TEST";
		String expected1 = "TEST1";

		PrintJob job = new PrintJob(expected);

		PrintJob job1 = new PrintJob(expected1);

		PrintJobExecutor abc = new PrintJobExecutor();

		assertTrue(abc.execute(job, pwd, ctx, userinfo));

		assertTrue(abc.execute(job1, pwd1, ctx1, userinfo1));
	}

	@Test
	public void printWithoutLogin() {
		String testPrint = "TEST";
		PrintJob job = new PrintJob(testPrint);

		PrintJobExecutor abc = new PrintJobExecutor();

		assertFalse(abc.execute(job, null, null, null));
	}

	@Test
	public void printWithFalseAuth() {
		EncryptedString pwd1 = new EncryptedString("pwd1");
		String expected = "TEST";
		PrintJob job = new PrintJob(expected);

		PrintJobExecutor xyz = new PrintJobExecutor();

		assertFalse(xyz.execute(job, pwd1, ctx, userinfo));
	}
}
