package edu.umb.cs680.hw05;

public class Main {
	public static void main(String[] args) {
		String firstName = "mark";

		String lastName = "hamill";

		EncryptedString pwd = new EncryptedString("starwars");

		User userObject = new User(firstName, lastName, pwd);

		SecurityContext ctx = new SecurityContext(userObject);

		firstName = "Alan";
		lastName = "Turing";

		EncryptedString pwd1 = new EncryptedString("pwd");

		User userObject1 = new User(firstName, lastName, pwd);

		SecurityContext ctx1 = new SecurityContext(userObject1);

		try {
			ctx.login(pwd, userObject);
			System.out.println(ctx.getState() instanceof LoggedIn);

			ctx1.login(pwd, userObject1);
			System.out.println(ctx1.getState() instanceof LoggedIn);

			ctx1.logout();
			System.out.println(ctx1.getState() instanceof LoggedOut);
			System.out.println(ctx.getState() instanceof LoggedIn);
			
			ctx.logout();
			System.out.println(ctx.getState() instanceof LoggedOut);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
