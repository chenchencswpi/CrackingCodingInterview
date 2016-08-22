package arraysAndStrings;

/**
 * Question: Write a method to replace all spaces in a string with '20%'. You may assume that the string has sufficient space at the end to hold the
 * additional characters, and that you are given the "true" length of the string. (Note: If implementing in Java, please use a character array so that you can perform
 * this operation in place.)
 * @author Chen
 *
 */
public class URLify {

}

class URLifySolution {
	/**
	 * Ignore the fact that the array has sufficient space at the end to hold additional characters.
	 * @param array
	 * @param actualLength
	 */
	void replaceStringWithAdditionalDS(char[] array, int actualLength) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < actualLength; i++) {
			if (array[i] != ' ') {
				sb.append(array[i]);
			} else {
				sb.append("20%");
			}
		}
		//put the string back to array;
		String s = sb.toString();
		for (int i = 0; i < s.length(); i++) {
			array[i] = s.charAt(i);
		}
	}
	/**
	 * First determine how long the final length will be, and then start to convert.
	 * @param array
	 * @param actualLength
	 */
	void replaceStringWithoutAdditionalDS(char[] array, int actualLength) {
		int realLength = 0;
		for (int i = 0; i < actualLength; i++) {
			if (array[i] == ' ') {
				realLength += 3;
			} else {
				realLength += 1;
			}
		}
		//start to convert from back
		int cursor = realLength - 1;
		for (int index = actualLength - 1; index >= 0; index--) {
			if (array[index] != ' ') {
				array[cursor--] = array[index]; 
			} else {
				array[cursor--] = '0';
				array[cursor--] = '2';
				array[cursor--] = '%';
			}
		}
	}
}