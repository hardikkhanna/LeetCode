/**
 * 
 */
package leetcode.dp.problems.easy;

import java.util.Scanner;

/**
 * @author NIPC-43
 *
 *         Date : Feb 22, 2021 Time : 5:14:38 PM
 */
public class UniquePaths {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		int n = sc.nextInt();
		int possiblePath = uniquePaths(m, n);
		System.out.println(possiblePath);
		sc.close();

	}

	/**
	 * @param m
	 * @param n
	 * @return
	 */
	private static int uniquePaths(int m, int n) {
		int[][] dp = new int[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (i == 0 || j == 0) {
					dp[i][j] = 1;
				} else {
					dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
				}
			}
		}
		return dp[m - 1][n - 1];
	}

}
