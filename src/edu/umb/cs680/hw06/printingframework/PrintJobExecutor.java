package edu.umb.cs680.hw06.printingframework;

import edu.umb.cs680.hw05.EncryptedString;
import edu.umb.cs680.hw05.SecurityContext;
import edu.umb.cs680.hw05.User;

abstract public class PrintJobExecutor {

	protected PrintJobExecutor() {
	}

	public boolean execute(PrintJob job, EncryptedString pwd, SecurityContext ctx, User user) {
		try {
			doAuthentication(pwd, ctx, user);
			doAccessControl();
			doPrint(job, pwd, ctx, user);
		} catch (Exception e) {
			doErrorHandling(e);
			return false;
		}

		return true;
	}

	protected abstract void doAuthentication(EncryptedString pwd, SecurityContext ctx, User user) throws Exception;

	protected abstract void doAccessControl();

	protected abstract void doPrint(PrintJob printObject, EncryptedString pwd, SecurityContext ctx, User user) throws Exception;

	protected abstract void doErrorHandling(Exception e);
}
