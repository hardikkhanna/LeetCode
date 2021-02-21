/**
 * 
 */
package leetcode.dp.problems.easy;

import java.util.Scanner;

/**
 * @author NIPC-43
 *
 *         Date : Feb 21, 2021 Time : 12:11:22 PM
 */
public class LongestCommonSubsequence {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str1 = sc.next();
		String str2 = sc.next();
		int length = LCS(str1, str2);
		System.out.println(length);
		sc.close();
	}

	/**
	 * @param str1
	 * @param str2
	 * @return
	 */
	private static int LCS(String str1, String str2) {
		int m = str1.length();
		int n = str2.length();
		int[][] dp = new int[m + 1][n + 1];
		for (int i = 0; i <= m; i++) {
			for (int j = 0; j <= n; j++) {
				if (i == 0 || j == 0)
					dp[i][j] = 0;

				else if (str1.charAt(i - 1) == str2.charAt(j - 1))
					dp[i][j] = dp[i - 1][j - 1] + 1;

				else
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
			}
		}

		return dp[m][n];
	}

}
