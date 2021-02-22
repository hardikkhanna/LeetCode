/**
 * 
 */
package leetcode.dp.problems.easy;

import java.util.Scanner;

/**
 * @author NIPC-43
 *
 *         Date : Feb 22, 2021 Time : 3:48:43 PM
 */
public class BinomialCoefficent {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int ans = binomialCoeff(n, k);
		System.out.println(ans);
		sc.close();
	}

	/**
	 * @param n
	 * @param k
	 * @return
	 */
	private static int binomialCoeff(int n, int k) {
		int[][] dp = new int[n + 1][k + 1];
		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= Math.min(i, k); j++) {
				if (j == 0 || j == i) {
					dp[i][j] = 1;
				} else {
					dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
				}
			}
		}
		return dp[n][k];
	}

}
