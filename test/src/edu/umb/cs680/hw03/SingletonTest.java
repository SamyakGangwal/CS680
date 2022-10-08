package edu.umb.cs680.hw03;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class SingletonTest {

	@Test
	public void VerifysingletonInstanceNotNull() {
		Singleton instance = Singleton.getInstance(5);

		assertNotEquals(null, instance);
	}

	@Test
	public void verifySingletonInstancecreation() {
		Singleton instance = Singleton.getInstance(5);

		Singleton instance2 = Singleton.getInstance(6);

		assertNotEquals(6, instance2.getNumber());

		assertEquals(instance.hashCode(), instance2.hashCode());
	}

	@Test
	public void verifySingletonInstancecreationUsingAssertSame() {
		Singleton instance = Singleton.getInstance(5);

		Singleton instance2 = Singleton.getInstance(6);

		assertSame(instance, instance2);
	}
}
