package arraysAndStrings;

/**
 * Implement a method to perform basic string compression using the counts of repeated characters. For example, the string aabcccccaaa would become a2b1c5a3. If the
 * "compressed" string would not become smaller than the original string, your method should return the original string. You can assume the string has only upppercase 
 * and lowercase letters(a-z).
 * @author Chen
 *
 */
public class StringCompression {

	public static void main(String[] args) {
		System.out.println(StirngCompressionSolution.compressString("aabccccca"));
	}
	
}

class StirngCompressionSolution {
	/**
	 * Native way to compress string.
	 * @param s
	 * @return
	 */
	static String compressString(String s) {
		if (s == null || s.length() == 0) return s;
		char curr = s.charAt(0);
		int count = 1;
		String res = "";
		for (int i = 1; i < s.length(); i++) {
			if (curr == s.charAt(i)) {
				count++;
			} else {
				res += "" + curr + count;
				curr = s.charAt(i);
				count = 1;
			}
		}
		res += "" + curr + count;
		return res.length() < s.length()? res : s;
	}
	
	/**
	 * Compress string with StringBuilder as additional data structure.
	 * @param s
	 * @return
	 */
	static String compressStringWithStringBuilder(String s) {
		if (s == null || s.length() == 0) return s;
		char curr = s.charAt(0);
		int count = 1;
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i < s.length(); i++) {
			if (curr == s.charAt(i)) {
				count++;
			} else {
				sb.append("" + curr + count);
				curr = s.charAt(i);
				count = 1;
			}
		}
		sb.append("" + curr + count);
		return sb.length() < s.length()? sb.toString() : s;
	}
	
	static String compressStringByApplyingCheckingFirst(String s) {
		if (s == null || s.length() == 0) return s;
		if (compressedLength(s) >= s.length()) return s;
		char curr = s.charAt(0);
		int count = 1;
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i < s.length(); i++) {
			if (curr == s.charAt(i)) {
				count++;
			} else {
				sb.append("" + curr + count);
				curr = s.charAt(i);
				count = 1;
			}
		}
		sb.append("" + curr + count);
		return sb.length() < s.length()? sb.toString() : s;
		
	}
	
	private static int compressedLength(String s) {
		char curr = s.charAt(0);
		int count = 1;
		int length = 0;
		for (int i = 1; i < s.length(); i++) {
			char c = s.charAt(i);
			if (curr == c) {
				count++;
			} else {
				length += ("" + count).length();
				curr = c;
				count = 1;
			}
		}
		return length + ("" + count).length();
	}
}
