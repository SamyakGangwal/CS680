package edu.umb.cs680.hw06.modelxyz;

import edu.umb.cs680.hw05.EncryptedString;
import edu.umb.cs680.hw05.SecurityContext;
import edu.umb.cs680.hw06.printingframework.PrintJob;

public class PrintJobExecutor extends edu.umb.cs680.hw06.printingframework.PrintJobExecutor {

	@Override
	protected void doAuthentication(EncryptedString pwd, SecurityContext ctx) throws Exception {
	// TODO Auto-generated method stub
	}

	@Override
	protected void doAccessControl() {
		// TODO Auto-generated method stub
	}

	@Override
	protected void doErrorHandling(Exception e) {
		System.out.println(e.getMessage());

	}

	@Override	
	protected void doPrint(PrintJob printObject, EncryptedString pwd, SecurityContext ctx) throws Exception {
		System.out.println(printObject.startPrintJob());

	}

}
