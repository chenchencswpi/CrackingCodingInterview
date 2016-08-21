package arraysAndStrings;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Question: Givens 2 arrays, write a method to decide if one is a permutation of the other.
 * @author Chen
 *
 */
public class CheckPermutations {

	public static void main(String[] args) {
		System.out.println(CheckPermutationsSolution.isPermutationWithoutDS("aabbccda", "abcdaacb"));
	}
	
}

class CheckPermutationsSolution {
	/**
	 * Method using hash table as additional data structure.
	 * @param s1
	 * @param s2
	 * @return
	 */
	static boolean isPermutation(String s1, String s2) {
		if (s1 == null) return s2 == null;
		if (s2 == null) return false;
		if (s1.length() != s2.length()) return false;
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		for (int i = 0; i < s1.length(); i++) {
			char c = s1.charAt(i);
			if (map.containsKey(c)) {
				map.put(c, map.get(c) + 1);
			} else {
				map.put(c, 1);
			}
		}
		for (int i = 0; i < s2.length(); i++) {
			char c = s2.charAt(i);
			if (!map.containsKey(c)) {
				return false;
			} else {
				int number = map.get(c);
				if (number > 1) {
					map.put(c, number - 1);
				} else {
					map.remove(c);
				}
			}
		}
		return true;
	}
	
	/**
	 * Use array as additional DS.
	 * @param s1
	 * @param s2
	 * @return
	 */
	static boolean isPermutationWithArray(String s1, String s2) {
		if (s1 == null) return s2 == null;
		if (s2 == null) return false;
		if (s1.length() != s2.length()) return false;
		int[] countArray = new int[256];
		for (int i = 0; i < s1.length(); i++) {
			char c = s1.charAt(i);
			countArray[c]++;
		}
		for (int i = 0; i < s2.length(); i++) {
			char c = s2.charAt(i);
			if (countArray[c] == 0) {
				return false;
			}
			countArray[c]--;
		}
		return true;
	}
	
	static boolean isPermutationWithoutDS(String s1, String s2) {
		if (s1 == null) return s2 == null;
		if (s2 == null) return false;
		if (s1.length() != s2.length()) return false;
		return sortString(s1).equals(sortString(s2));
	}
	
	static private String sortString(String s) {
		char[] array = s.toCharArray();
		Arrays.sort(array);
		return new String(array);
	}
}