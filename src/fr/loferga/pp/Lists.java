package fr.loferga.pp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lists {
	
	// 1.01 (*) Find the last element of a list.
	public static <T> T lastElement(List<T> list) {
		return list.get(list.size()-1);
	}
	
	// 1.02 (*) Find the last but one element of a list.
	public static <T> T lastButOneElement(List<T> list) {
		return list.get(list.size()-2);
	}
	
	// 1.03 (*) Find the K'th element of a list.
	public static <T> T get(List<T> list, int k) {
		return list.get(k);
	}
	
	// 1.04 (*) Find the number of elements of a list.
	public static int length(List<?> list) {
		return list.size();
	}
	
	// 1.05 (*) Reverse a list.
	public static <T> List<T> reverse(List<T> list) {
		List<T> reversed = new ArrayList<>(list);
		int len = list.size();
		for (int i = 0; i<len; i++)
			reversed.set(i, list.get(len-i-1));
		return reversed;
	}
	
	// 1.06 (*) Find out whether a list is a palindrome.
	public static boolean isPal(List<Object> list) {
		return list.equals(reverse(list));
	}
	
	// 1.07 (**) Flatten a nested list structure.
	@SuppressWarnings("unchecked")
	public static <T> List<T> flatten(List<?> list) {
		List<T> flatten = new ArrayList<>();
		int len = list.size();
		for (int i = 0; i<len; i++) {
			Object e = list.get(i);
			if (e instanceof List<?> l)
				flatten.addAll(flatten(l));
			else flatten.add((T) e);
		}
		return flatten;
	}
	
	// 1.08 (**) Eliminate consecutive duplicates of list elements.
	public static void compress(List<Object> list) {
		for (int i = 1; i<list.size(); i++)
			if (list.get(i).equals(list.get(i-1)))
				list.remove(i--);
	}
	
	// 1.09 (**) Pack consecutive duplicates of list elements into sublists.
	public static <T> List<Object> packDuplicates(List<T> list) {
		List<Object> duplicates = new ArrayList<>();
		List<T> pack = new ArrayList<>(Arrays.asList(list.get(0)));
		int len = list.size();
		for (int i = 1; i<len; i++) {
			T e = list.get(i);
			if (e.equals(pack.get(0)))
				pack.add(e);
			else {
				duplicates.add(pack);
				pack = new ArrayList<>(Arrays.asList(e));
			}
		}
		duplicates.add(pack);
		return duplicates;
	}
	
	// 1.10 (*) Run-length encoding of a list.
	public static void encode(List<Object> list) {
		int len = list.size();
		for (int i = 0; i<len; i++)
			if (list.get(i) instanceof List<?> l)
				list.set(i, Arrays.asList(l.size(), l.get(0)));
	}
	
	// 1.11 (*) Modified run-length encoding.
	public static void encodeModified(List<Object> list) {
		int len = list.size();
		for (int i = 0; i<len; i++)
			if (list.get(i) instanceof List<?> l && (int) l.get(0) == 1)
				list.set(i, l.get(1));
	}
	
	// 1.12 (**) Decode a run-length encoded list.
	public static List<Object> decode(List<Object> list) {
		List<Object> decoded = new ArrayList<>();
		for (Object e : list) {
			if (e instanceof List<?> l) {
				int n = (int) l.get(0);
				for (int k = 0; k<n; k++)
					decoded.add(l.get(1));
			} else
				decoded.add(e);
		}
		return decoded;
	}
	
	// 1.13 (**) Run-length encoding of a list (direct solution).
	public static List<Object> encodeDirect(List<Object> list) {
		List<Object> encoded = new ArrayList<>();
		return encoded;
	}
	
	// 1.14 (*) Duplicate the elements of a list.
	// 1.15 (**) Duplicate the elements of a list a given number of times.
	// 1.16 (**) Drop every N'th element from a list.
	// 1.17 (*) Split a list into two parts; the length of the first part is given.
	// 1.18 (**) Extract a slice from a list.
	// 1.19 (**) Rotate a list N places to the left.
	// 1.20 (*) Remove the K'th element from a list.
	// 1.21 (*) Insert an element at a given position into a list.
	// 1.22 (*) Create a list containing all integers within a given range.
	// 1.23 (**) Extract a given number of randomly selected elements from a list.
	// 1.24 (*) Lotto: Draw N different random numbers from the set 1..M.
	// 1.25 (*) Generate a random permutation of the elements of a list.
	// 1.26 (**) Generate the combinations of K distinct objects chosen from the N elements of a list
	// 1.27 (**) Group the elements of a set into disjoint subsets.
	// 1.28 (**) Sorting a list of lists according to length of sublists
	
	
	/*
	 * =================================================
	 *                     TESTS
	 * =================================================
	 */
	
	public static void main(String[] args) {
		List<Object> ll = Arrays.asList(3, 2, 5, 6, 9);
		System.out.println("list: " + ll);
		System.out.println("last element: " + lastElement(ll));
		System.out.println("last but one element: " + lastButOneElement(ll));
		System.out.println("k\'th element with k = 2: " + get(ll, 2));
		System.out.println("list length: " + length(ll));
		System.out.println("reversed list: " + reverse(ll));
		System.out.println("is palindrome: " + isPal(ll));
		System.out.println("is [9, 2, 9] pal?: " + isPal(Arrays.asList(9, 2, 9)));
		System.out.println("flatten [2, [3, 4], [[4], 7]]: " + flatten((List<?>) Arrays.asList(2, Arrays.asList(3, 4), Arrays.asList(Arrays.asList(4), 7))));
		List<Object> ltc = new ArrayList<>(Arrays.asList('a', 'a', 'b', 'b', 'b', 'c', 'b', 'f', 'f'));
		System.out.print("compress " + ltc + ": ");
		List<Object> ltcc1 = new ArrayList<>(ltc);
		compress(ltcc1);
		System.out.println(ltcc1);
		List<Object> ltcc2 = packDuplicates(new ArrayList<>(ltc));
		System.out.println("packDuplicates " + ltc + ": " + ltcc2);
		encode(ltcc2);
		System.out.println("encoded: " + ltcc2);
		encodeModified(ltcc2);
		System.out.println("modifiedEncoded: " + ltcc2);
		System.out.println("decoded: " + decode(ltcc2));
	}
	
}