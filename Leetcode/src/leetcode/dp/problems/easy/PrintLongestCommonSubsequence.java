/**
 * 
 */
package leetcode.dp.problems.easy;

import java.util.Scanner;

/**
 * @author NIPC-43
 *
 *         Date : Feb 21, 2021 Time : 1:24:10 PM
 */
public class PrintLongestCommonSubsequence {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String word1 = sc.next();
		String word2 = sc.next();
		String longest = getLCS(word1, word2);
		System.out.println(longest);
		sc.close();
	}

	/**
	 * @param word1
	 * @param word2
	 * @return
	 */
	private static String getLCS(String word1, String word2) {
		int m = word1.length();
		int n = word2.length();
		int[][] dp = new int[m + 1][n + 1];
		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				}
			}
		}
		StringBuilder str = new StringBuilder();
		int i = m;
		int j = n;
		while (i > 0 && j > 0) {

			if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
				str.append(word1.charAt(i - 1));
				i--;
				j--;
			} else if (dp[i - 1][j] > dp[i][j - 1]) {
				i--;
			} else {
				j--;
			}

		}
		return str.reverse().toString();
	}

}
