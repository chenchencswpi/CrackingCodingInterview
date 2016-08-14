package arraysAndStrings;

import java.util.HashSet;

/**
 * Question: Implement an algorithm to determine if a string has all unique characters.
 * Follow up: What if you cannot use additional data structures?
 * @author chenchen
 *
 */
public class IsUnique {
	public static void main(String[] args) {
		//new IsUniqueSolution().isUniqueWithAdditionalDS("abc");
	}
}

class IsUniqueSolution {
	/**
	 * Method using hashtable as additional data structure.
	 * @param s
	 * @return
	 */
	boolean isUniqueWithAdditionalDS(String s) {
		if (s == null || s.length() == 0) {
			return true;
		}
		HashSet<Character> set = new HashSet<Character>();
		for (int index = 0; index < s.length(); index++) {
			char current = s.charAt(index);
			if (set.contains(current)) {
				return false;
			}
			set.add(current);
		}
		return true;
	}
	
	/**
	 * Method using array as additional data structure.
	 * Check with your interviewer about character set.
	 * @param s
	 * @return
	 */
	boolean isUniqueWithAddtionalDS2(String s) {
		if (s == null || s.length()  == 0) {
			return true;
		}
		boolean[] isFound = new boolean[256];
		for (int index = 0; index < s.length(); index++) {
			char current = s.charAt(index);
			if (isFound[current]) {
				return false;
			}
			isFound[current] = true;
		}
		return true;
	}
	
	/**
	 * Method without using array as additional data structure.
	 * Sacrifice time complexity for saving time complexity.
	 * @param s
	 * @return
	 */
	boolean isUniqueWithoutAdditionalDS(String s) {
		if (s == null || s.length() == 0) {
			return true;
		}
		for (int index = 0; index < s.length() - 1; index++) {
			char current = s.charAt(index);
			for (int mover = index + 1; mover < s.length(); mover++) {
				if (current == s.charAt(mover)) {
					return false;
				}
			}
		}
		return true;
	}
}
