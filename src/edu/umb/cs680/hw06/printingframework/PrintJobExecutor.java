package edu.umb.cs680.hw06.printingframework;

import edu.umb.cs680.hw05.EncryptedString;
import edu.umb.cs680.hw05.SecurityContext;

abstract public class PrintJobExecutor {

	protected PrintJobExecutor() {
	}

	public String execute(PrintJob job, EncryptedString pwd, SecurityContext ctx) {
		String printJobString = job.getFirstPrintJob();
		
		try {
			doAuthentication(pwd, ctx);
			doAccessControl();
			doPrint(job, pwd, ctx);
		} catch (Exception e) {
			doErrorHandling(e);
		}

		return printJobString;
	}

	protected abstract void doAuthentication(EncryptedString pwd, SecurityContext ctx) throws Exception;

	protected abstract void doAccessControl();

	protected abstract void doPrint(PrintJob printObject, EncryptedString pwd, SecurityContext ctx) throws Exception;

	protected abstract void doErrorHandling(Exception e);
}
