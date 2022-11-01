package edu.umb.cs680.hw06.modelabc;

import static org.junit.jupiter.api.Assertions.assertEquals;
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
		this.userinfo = new User("Alan", "Turing");
		this.pwd = new EncryptedString("pwd");
		this.ctx = new SecurityContext(this.userinfo);
	}

	@Test
	public void printInModelABC() {
		String expected = "TEST";
		PrintJob job = new PrintJob(expected);

		PrintJobExecutor xyz = new PrintJobExecutor();

		String actual = xyz.execute(job, pwd, ctx);

		assertEquals(expected, actual);
	}

	@Test
	public void multiplePrint() {
		String[] expected = { "TEST", "TEST1" };

		PrintJob job = new PrintJob(expected[0]);

		job.addPrintJob(expected[1]);

		for (int i = 0; i < expected.length; i++) {
			PrintJobExecutor xyz = new PrintJobExecutor();

			String actual = xyz.execute(job, pwd, ctx);

			assertEquals(expected[i], actual);
		}
	}

	@Test
	public void multiUserPrint() {
		User userinfo1 = new User("Alan", "Turing");
		EncryptedString pwd1 = new EncryptedString("pwd");
		SecurityContext ctx1 = new SecurityContext(userinfo1);

		String expected = "TEST";
		String expected1 = "TEST1";

		PrintJob job = new PrintJob(expected);

		PrintJob job1 = new PrintJob(expected1);

		PrintJobExecutor abc = new PrintJobExecutor();

		String actual = abc.execute(job, pwd, ctx);

		String actual1 = abc.execute(job1, pwd1, ctx1);

		assertEquals(expected1, actual1);

		assertEquals(expected, actual);
	}
}
