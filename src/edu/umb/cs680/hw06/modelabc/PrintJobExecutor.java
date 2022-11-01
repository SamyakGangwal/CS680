package edu.umb.cs680.hw06.modelabc;

import edu.umb.cs680.hw05.EncryptedString;
import edu.umb.cs680.hw05.SecurityContext;
import edu.umb.cs680.hw05.User;
import edu.umb.cs680.hw06.printingframework.PrintJob;

public class PrintJobExecutor extends edu.umb.cs680.hw06.printingframework.PrintJobExecutor {

	@Override
	protected void doAuthentication(EncryptedString pwd, SecurityContext ctx, User user) throws Exception{
		ctx.login(pwd, user);
	}

	@Override
	protected void doAccessControl() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void doPrint(PrintJob printObject, EncryptedString pwd, SecurityContext ctx, User user) throws Exception {
		doAuthentication(pwd, ctx, user);
		System.out.println(printObject.startPrintJob());
		
	}

	@Override
	protected void doErrorHandling(Exception e) {
		System.out.println(e.getMessage());

	}
	
}
