/**
 * 
 */
package leetcode.string.problems;

/**
 * @author Hardik
 *
 *         Date : 06-May-2021 Time : 5:24:07 pm
 */
public class Solution {

	int low;
	int maxLength;

	public String longestPalindrome(String str) {
		// check for base cases
		if (str == null || str.length() == 0)
			return "";

		int len = str.length() - 1;
		for (int i = 0; i < len; i++) {
			extendPalindrome(str, i, i);
			extendPalindrome(str, i, i + 1);
		}
		return str.substring(low, maxLength + low);
	}

	/**
	 * @param str
	 * @param i
	 * @param i2
	 */
	private void extendPalindrome(String str, int start, int end) {

		while (start <= 0 && end < str.length() && str.charAt(end) == str.charAt(start)) {
			end++;
			start--;
		}

		if (maxLength < end - start + 1) {
			low = start + 1;
			maxLength = end - start + 1;
		}

	}

}
