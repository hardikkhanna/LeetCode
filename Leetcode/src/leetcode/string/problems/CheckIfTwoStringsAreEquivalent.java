/**
 * 
 */
package leetcode.string.problems;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author NIPC-43
 *
 *         Date : Jan 3, 2021 Time : 2:39:03 PM
 */
public class CheckIfTwoStringsAreEquivalent {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		String[] words1 = new String[n];
		String[] words2 = new String[m];
		for (int i = 0; i < n; i++) {
			words1[i] = sc.next();
		}
		for (int i = 0; i < m; i++) {
			words2[i] = sc.next();
		}
		boolean ans = arrayStringsAreEqual(words1, words2);
		System.out.println(ans);
		sc.close();
	}

	/**
	 * @param words1
	 * @param words2
	 * @return
	 */
	private static boolean arrayStringsAreEqual(String[] words1, String[] words2) {
		if (Arrays.toString(words1).replace(", ", "").equalsIgnoreCase(Arrays.toString(words2).replace(", ", "")))
			return true;
		return false;
	}

}
