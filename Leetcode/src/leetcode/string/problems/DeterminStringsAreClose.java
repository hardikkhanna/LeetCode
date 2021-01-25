/**
 * 
 */
package leetcode.string.problems;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Hardik
 *
 *         Date : Jan 23, 2021 Time : 7:39:01 AM
 */
public class DeterminStringsAreClose {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		String word = sc.next();
		Boolean ans = closeStrings(str, word);
		System.out.println(ans);
		sc.close();

	}

	/**
	 * @param str
	 * @param word
	 * @return
	 */
	private static Boolean closeStrings(String word1, String word2) {
		if (word1.length() != word2.length())
			return false;

		int[] f1 = new int[26];
		int[] v1 = new int[26];
		for (char c : word1.toCharArray()) {
			f1[c - 'a']++;
			v1[c - 'a'] = 1;
		}

		int[] f2 = new int[26];
		int[] v2 = new int[26];
		for (char c : word2.toCharArray()) {
			f2[c - 'a']++;
			v2[c - 'a'] = 1;
		}

		Arrays.sort(f1);
		Arrays.sort(f2);

		return Arrays.equals(f1, f2) && Arrays.equals(v1, v2);
	}

}
