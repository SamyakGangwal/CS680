package edu.umb.cs680.hw01;

import static org.junit.jupiter.api.Assertions.*;

import java.util.LinkedList;

import org.junit.jupiter.api.Test;

public class PrimeGeneratorTest {
	// TODO: Add tests fail for Primegenerator constructor

	@Test
	public void isEvenTrue() {
		PrimeGenerator evenNumber = new PrimeGenerator(1, 1000);

		boolean actual = evenNumber.isEven(4);

		assertTrue(actual);
	}

	@Test
	public void PrimeGeneratorObjectCreationSuccess() {
		PrimeGenerator primeObj = new PrimeGenerator(1, 10);

		long from = 1;
		long to = 10;

		assertEquals(from, primeObj.from);

		assertEquals(to, primeObj.to);
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

		LinkedList<Long> expectedPrimes = new LinkedList<>();

		expectedPrimes.add((long) 2);
		expectedPrimes.add((long) 3);
		expectedPrimes.add((long) 5);
		expectedPrimes.add((long) 7);
		expectedPrimes.add((long) 11);

		assertEquals(expectedPrimes, actualPrimes);
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

		LinkedList<Long> expectedPrimes = new LinkedList<>();

		expectedPrimes.add((long) 2);
		expectedPrimes.add((long) 3);
		expectedPrimes.add((long) 5);
		expectedPrimes.add((long) 7);
		expectedPrimes.add((long) 11);

		assertEquals(expectedPrimes, primeNumbers.primes);
	}

}
