package arraysAndStrings;

/**
 * Assume you have a method isSubstring which checks if one word is a substring of another. Given 2 strings, s1 and s2, write code to check if s2 is a rotation of s1
 * using only one call to isSubstring(e.g., "waterbottle" is a toration of "erbottlewat").
 * @author Chen
 *
 */
public class StringRotation {

	public static void main(String[] args) {
		System.out.println(StringRotationSolution.isRotatedString("erbottlewat", "waterbottle"));
	}
	
}

class StringRotationSolution {
	/**
	 * 
	 * @param original
	 * @param test
	 * @return
	 */
	public static boolean isRotatedString(String original, String test) {
		return (original + original).indexOf(test) != -1;
	}
}