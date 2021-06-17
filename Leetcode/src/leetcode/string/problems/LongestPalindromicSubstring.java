/**
 * 
 */
package leetcode.string.problems;

import java.util.Scanner;

/**
 * @author Hardik
 *
 *         Date : Jan 20, 2021 Time : 11:44:55 AM
 */
public class LongestPalindromicSubstring {

	/**
	 * @param args
	 */
	static int inital;
	static int last;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		str = longestPalindrome(str);
		System.out.println(str);

		str = helper(str);
		System.out.println(str);
		sc.close();
		
		Solution sol = new Solution();
		System.out.println(sol.longestPalindrome(str));
	}

	/**
	 * @param str
	 * @return
	 */
	private static String helper(String str) {
		if (str == null || str.length() == 0) {
			return "";
		}

		int i = 0;
		int j = str.length() - 1;
		inital = Integer.MAX_VALUE;
		last = Integer.MIN_VALUE;
		return helper(str, i, j);

	}

	private static String helper(String str, int start, int end) {
		if (str == null || str.length() == 0)
			return "";
		if (str.charAt(start) == str.charAt(end) && isPalindrome(str, start, end)) {
			inital = Math.min(inital, start);
			last = Math.max(last, end);
			return str.substring(inital, last + 1);
		}

		String opt1 = helper(str, start + 1, end);
		String opt2 = helper(str, start, end - 1);
		String opt3 = helper(str, start + 1, end + 1);

		if (opt1.length() > opt2.length() && opt1.length() > opt3.length()) {
			return opt1;
		} else if (opt2.length() > opt1.length() && opt2.length() > opt3.length()) {
			return opt2;
		}
		return opt3;

	}

	/**
	 * @param str
	 * @param start
	 * @param end
	 * @return
	 */
	private static boolean isPalindrome(String str, int start, int end) {
		if (str == null || str.length() == 0)
			return true;

		while (start < end) {
			if (str.charAt(start) != str.charAt(end)) {
				return false;
			}
			start++;
			end--;
		}
		return true;
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
