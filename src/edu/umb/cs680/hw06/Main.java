package edu.umb.cs680.hw06;

import edu.umb.cs680.hw05.EncryptedString;
import edu.umb.cs680.hw05.SecurityContext;
import edu.umb.cs680.hw05.User;
import edu.umb.cs680.hw06.modelxyz.PrintJobExecutor;
import edu.umb.cs680.hw06.printingframework.PrintJob;

public class Main {
	public static void main(String[] args) {
		String test = "TEST";
		PrintJob job = new PrintJob(test);

		PrintJobExecutor xyz = new PrintJobExecutor();

		xyz.execute(job, null, null, null);

		EncryptedString pwd = new EncryptedString("pwd");
		User userinfo = new User("Alan", "Turing", pwd);
		SecurityContext ctx = new SecurityContext(userinfo);

		String test1 = "TEST";
		PrintJob job1 = new PrintJob(test1);

		PrintJobExecutor abc = new PrintJobExecutor();

		abc.execute(job1, pwd, ctx, userinfo);
	}

}
