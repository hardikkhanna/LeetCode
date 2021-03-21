/**
 * 
 */
package leetcode.string.problems;

import java.util.Scanner;

/**
 * @author Hardik
 *
 *         Date : Mar 9, 2021 Time : 11:41:43 AM
 */

/*
 * Given a string S, you need to find and return the lexicographically first
 * palindrome string that can be made using characters of S. Return an empty
 * string if no palindrome can be created using S.
 */
public class FirstPalindrom {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		str = nextPalindrome(str);
		System.out.println(str);
		sc.close();

	}

	/**
	 * @param str
	 * @return
	 */
	private static String nextPalindrome(String str) {
		if (str.length() == 0)
			return "";
		int[] freq = new int[26];
		for (int i = 0; i < str.length(); i++) {
			int index = str.charAt(i) - 'a';
			freq[index]++;
		}
		int count = 0;
		for (int i = 0; i < freq.length; i++) {
			if (freq[i] % 2 != 0) {
				count++;
			}
		}
		if ((str.length() % 2 != 0 && count > 1) || (str.length() % 2 == 0 && count >= 1)) {
			return "";
		}
		String firstHalf = "";
		String secondHalf = "";
		int index = 0;
		for (int i = 0; i < freq.length; i++) {
			if (freq[i] == 1) {
				index = i;
				continue;
			}
			while (freq[i] > 0) {
				firstHalf += (char) (97 + i);
				secondHalf = (char) (97 + i) + secondHalf;
				freq[i] -= 2;
			}
		}
		if (str.length() % 2 != 0)
			return firstHalf + (char) (97 + index) + secondHalf;
		return firstHalf + secondHalf;
	}

}
