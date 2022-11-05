package fr.loferga.pp;

public class Arithmetic {
	
	// 2.01 (**) Determine whether a given integer number is prime.
	public static boolean isPrime(int n) {
		double sqrtn = Math.sqrt(n);
		for (int i = 2; i<=sqrtn; i++)
			if (n % i == 0)
				return false;
		return true;
	}
	
	// 2.02 (**) Determine the prime factors of a given positive integer.
	
	/*
	 * =================================================
	 *                     TESTS
	 * =================================================
	 */
	
	public static void main(String[] args) {
		
	}
	
}