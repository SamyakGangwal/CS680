package edu.umb.cs680.hw02;

import static org.junit.jupiter.api.Assertions.*;

import java.util.LinkedList;

import org.junit.jupiter.api.Test;

public class PrimeGeneratorTest {

	
	@Test
	public void primeGeneratorObjectCreationSuccess() {
		PrimeGenerator primeObj = new PrimeGenerator(1, 10);
		
		long from = 1;
		long to = 10;
		
		assertEquals(from, primeObj.from);
		
		assertEquals(to, primeObj.to);
	}
	
	@Test
	public void primeGeneratorObjectCreationFailure() {
		long from = 0;
		long to = 10;
		
		try {
			PrimeGenerator primeObj = new PrimeGenerator(from, to);
			fail("Incorrect input values from: " + from + " to=" + to);
		} catch (RuntimeException ex) {
			assertEquals("Wrong input values: from=" + from + " to=" + to, ex.getMessage());
		}
	}

	@Test
	public void isEvenTrue() {
		PrimeGenerator evenNumber = new PrimeGenerator(1, 1000);

		boolean actual = evenNumber.isEven(4);

		assertTrue(actual);
	}

	@Test
	public void isEvenNegative() {
		PrimeGenerator evenNumber = new PrimeGenerator(1, 1000);

		boolean actual = evenNumber.isEven(-4);

		assertTrue(actual);
	}


	@Test
	public void isEvenFalse() {
		PrimeGenerator oddNumber = new PrimeGenerator(1, 1000);

		boolean actual = oddNumber.isEven(9);

		assertFalse(actual);
	}

	@Test
	public void isPrimeTrue() {
		PrimeGenerator prime = new PrimeGenerator(1, 1000);

		boolean actual = prime.isPrime(3);

		assertTrue(actual);
	}

	@Test
	public void isPrimeFalse() {
		PrimeGenerator prime = new PrimeGenerator(1, 1000);

		boolean actual = prime.isPrime(4);

		assertFalse(actual);
	}

	@Test
	public void generate5Primes() {
		PrimeGenerator primeNumbers = new PrimeGenerator(1, 12);

		primeNumbers.generatePrimes();

		LinkedList<Long> actualPrimes = primeNumbers.getPrimes();

		Long[] expectedPrimes = {2L, 3L, 5L, 7L, 11L};

		assertArrayEquals(expectedPrimes, actualPrimes.toArray());
	}

	@Test
	public void get0Primes() {
		PrimeGenerator primeNumbers = new PrimeGenerator(1, 50);

		LinkedList<Long> actualPrimes = primeNumbers.getPrimes();

		LinkedList<Long> expectedPrimes = new LinkedList<>();

		assertEquals(expectedPrimes, actualPrimes);
	}

	@Test
	public void generate5PrimesWithoutgetPrimes() {
		PrimeGenerator primeNumbers = new PrimeGenerator(1, 12);

		primeNumbers.generatePrimes();

		Long[] expectedPrimes = {2L, 3L, 5L, 7L, 11L};

		assertArrayEquals(expectedPrimes, primeNumbers.primes.toArray());
	}

}
