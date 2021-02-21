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

	static int[][] DP;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String word1 = sc.next();
		String word2 = sc.next();
		int operations = editDistance(word1, word2);
		System.out.println(operations);
		printPossibleWays(word1, word2);
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
		DP = dp;
		return dp[m][n];
	}

	/**
	 * 
	 */
	private static void printPossibleWays(String word1, String word2) {
		int i = word1.length();
		int j = word2.length();
		while (i != 0 && j != 0) {
			if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
				i--;
				j--;
			} else if (DP[i][j] == DP[i - 1][j - 1] + 1) { // Replace the character
				System.out.println("Replaced " + word1.charAt(i - 1) + " to " + word2.charAt(j - 1));
				i--;
				j--;
			} else if (DP[i][j] == DP[i - 1][j] + 1) {
				System.out.println("Delete	d " + word1.charAt(i - 1));
				i--;
			} else if (DP[i][j] == DP[i][j - 1] + 1) {
				System.out.println("Inserted " + word2.charAt(j - 1));
				j--;
			}
		}
	}

}
