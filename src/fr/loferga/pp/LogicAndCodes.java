package fr.loferga.pp;

public class LogicAndCodes {
	
	public static boolean and(final boolean A, final boolean B) {
		return A && B;
	}
	
	public static boolean or(final boolean A, final boolean B) {
		return A || B;
	}
	
	public static boolean nand(final boolean A, final boolean B) {
		return !and(A, B);
	}
	
	public static boolean nor(final boolean A, final boolean B) {
		return !or(A, B);
	}
	
	public static boolean xor(final boolean A, final boolean B) {
		return nand(A, B) && or(A, B);
	}
	
	public static boolean impl(final boolean A, final boolean B) {
		return or(!A, B);
	}
	
	public static boolean equ(final boolean A, final boolean B) {
		return and(A, B) || and(!A, !B);
	}
	
	// 3.01 (**) Truth tables for logical expressions.
	
	// 3.02 (*) Truth tables for logical expressions (2).
	
	/*
	 * =================================================
	 *                     TESTS
	 * =================================================
	 */
	
	public static void main(String[] args) {
	}
	
}