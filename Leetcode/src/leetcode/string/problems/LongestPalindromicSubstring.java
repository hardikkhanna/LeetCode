/**
 * 
 */
package leetcode.string.problems;

/**
 * @author NIPC-43
 *
 *         Date : Jan 20, 2021 Time : 11:44:55 AM
 */
public class LongestPalindromicSubstring {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String str = "babad";
		str = longestPalindrome(str);
		System.out.println(str);

	}

	/**
	 * @param str
	 * @return
	 */
//	private static String longestPalindrome(String str) {
//		if (str.length() == 1 || (str.length() == 2 && (str.charAt(0) != str.charAt(1)))) {
//			return String.valueOf(str.charAt(0));
//		}
//		if (str.chars().distinct().count() == 1) {
//			return str;
//		}
//		int max = 0;
//		StringBuilder longest = new StringBuilder();
//		for (int i = 0; i < str.length() - max; i++) {
//			StringBuilder substr = null;
//			for (int j = i + max; j < str.length(); j++) {
//				substr = new StringBuilder(str.substring(i, j + 1).toString());
//				StringBuilder reverse = new StringBuilder(substr).reverse();
//				if (reverse.toString().equalsIgnoreCase(substr.toString()) && max < substr.length()) {
//					longest = substr;
//					max = substr.length();
//
//				}
//			}
//		}
//		if (longest.length() == 0)
//			return String.valueOf(str.charAt(0));
//		return longest.toString();
//	}

	public static String longestPalindrome(String s) {
		String result = "";
		int len = 0;
		boolean[][] isPali = new boolean[s.length()][s.length()];
		for (int i = s.length() - 1; i >= 0; i--) {
			for (int j = i; j < s.length(); j++) {
				if (s.charAt(i) == s.charAt(j) && (j - i < 2 || isPali[i + 1][j - 1])) {
					isPali[i][j] = true;
					if (j - i + 1 > len) {
						result = s.substring(i, j + 1);
						len = j - i + 1;
					}
				}
			}
		}
		return result;
	}
}
