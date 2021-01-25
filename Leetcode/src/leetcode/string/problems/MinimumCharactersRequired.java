/**
 * 
 */
package leetcode.string.problems;

import java.util.Arrays;

/**
 * @author Hardik
 *
 *         Date : Jan 24, 2021 Time : 9:23:03 AM
 */
public class MinimumCharactersRequired {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String a = "dabadd";
		String b = "cda";
		int ans = minCharacters(a, b);
		System.out.println(ans);

	}

	/**
	 * @param a
	 * @param b
	 * @return
	 */
	private static int minCharacters(String a, String b) {
		if (a.length() > b.length())
			return b.length();
		if (b.length() > a.length())
			return a.length();
		char[] arr1 = (a.toCharArray());
		char[] arr2 = (b.toCharArray());
		Arrays.sort(arr1);
		Arrays.sort(arr2);
		int count = 0;
		for (int i = 0; i < arr1.length; i++) {
			if (arr1[i] != arr2[i])
				count += 2;
		}
		return count;
	}

}
