package arraysAndStrings;

/**
 * Question: There are three types of edits that can be performed on strings: insert a character, remove a character, or replace a character. Given 2 strings,
 * write a function to check if they are one edit (or zero edits) away. 
 * @author Chen
 *
 */
public class OneAway {

}

class OneAwaySolution {
	static boolean isOneEditAway(String s1, String s2) {
		String longerString = s1.length() >= s2.length()? s1 : s2;
		String shorterString = s1.length() < s2.length()? s1 : s2;
		if (longerString.length() == shorterString.length()) {
			return isReplaced(longerString, shorterString);
		} else if (longerString.length() - shorterString.length() == 1){
			return isInserted(longerString, shorterString);
		} else {
			return false;
		}
	}
	
	private static boolean isReplaced(String s1, String s2) {
		if (s1.equals(s2)) return false;
		for (int i = 0; i < s1.length(); i++) {
			if (s1.charAt(i) != s2.charAt(i)) {
				return s1.substring(i + 1).equals(s2.substring(i + 1));
			}
		}
		return true;
	}
	
	private static boolean isInserted(String longerString, String shorterString) {
		for (int i = 0; i < shorterString.length(); i++) {
			if (longerString.charAt(i) != shorterString.charAt(i)) {
				return longerString.substring(i + 1).equals(shorterString.substring(i));
			}
		}
		return false;
	}
}
