/**
 * 
 */
package leetcode.dp.problems.easy;

import java.util.Scanner;

/**
 * @author NIPC-43
 *
 *         Date : Feb 21, 2021 Time : 7:54:38 PM
 */
public class EditDistance {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String word1 = sc.next();
		String word2 = sc.next();
		int operations = editDistance(word1, word2);
		System.out.println(operations);
		sc.close();
	}

	/**
	 * @param str
	 * @return
	 */
	private static int editDistance(String word1, String word2) {
		int m = word1.length();
		int n = word2.length();
		int[][] dp = new int[m + 1][n + 1];
		for (int i = 0; i <= m; i++) {
			for (int j = 0; j <= n; j++) {
				if (i == 0)
					dp[i][j] = j;
				else if (j == 0)
					dp[i][j] = i;
				else if (word1.charAt(i - 1) == word2.charAt(j - 1))
					dp[i][j] = dp[i - 1][j - 1];
				else
					dp[i][j] = 1 + Math.min(dp[i][j - 1], Math.min(dp[i - 1][j - 1], dp[i - 1][j]));
			}
		}
		return dp[m][n];
	}

}
