/**
 * 
 */
package leetcode.weeklycontest.problems;

import java.util.Scanner;

/**
 * @author Hardik
 *
 *         Date : Feb 21, 2021 Time : 8:31:05 AM
 */
public class WeeklyContest229 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String word1 = sc.next();
		String word2 = sc.next();
		String output = mergeAlternately(word1, word2);
		System.out.println(output);

		String boxes = sc.next();
		int[] operations = minOperations(boxes);
		for (int i = 0; i < operations.length; i++) {
			System.out.print(operations[i] + " ");
		}

		sc.close();
	}

	/**
	 * @param boxes
	 * @return
	 */
	private static int[] minOperations(String boxes) {
		if (boxes.length() < 2) {
			return new int[] { 0 };
		}
		int[] ans = new int[boxes.length()];
		for (int i = 0; i < boxes.length(); i++) {
			for (int j = 0; j < boxes.length(); j++) {
				ans[i] += Math.abs(i - j) * Character.getNumericValue(boxes.charAt(j));
			}
		}

		return ans;
	}

	/**
	 * @param word1
	 * @param word2
	 * @return
	 */
	private static String mergeAlternately(String word1, String word2) {
		StringBuilder ans = new StringBuilder();
		int j = 0;
		int i = 0;
		for (i = 0; i < word1.length() && j < word2.length(); i++) {
			ans.append(word1.charAt(i));
			ans.append(word2.charAt(j));
			j++;
		}
		if (j != word2.length())
			ans.append(word2.substring(j));
		if (i != word1.length())
			ans.append(word1.substring(i));
		return ans.toString();
	}

}
