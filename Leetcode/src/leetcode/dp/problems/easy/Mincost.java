/**
 * 
 */
package leetcode.dp.problems.easy;

import leetcode.array.problems.ScannerInput;

/**
 * @author Hardik
 *
 *         Date : 08-Jun-2021 Time : 5:10:27 pm
 */
public class Mincost extends ScannerInput {

	/**
	 * @param args
	 */
	static int[][] memo;

	public static void main(String[] args) {
		int[][] arr = get2DArray();
		int minCost = minCostRec(arr, arr.length - 1, arr.length - 1, 0, 0);
		System.out.println("Recusrive sol : " + minCost);

		memo = new int[arr.length][arr.length];
		for (int i = 0; i < arr.length; i++)
			for (int j = 0; j < arr.length; j++)
				memo[i][j] = Integer.MAX_VALUE;
		minCost = minCostMemo(arr, arr.length - 1, arr.length - 1, 0, 0);
		System.out.println("Memoization answer : " + minCost);

		minCost = minCostTabular(arr, arr.length, arr.length);
		System.out.println("Tabular answer = " + minCost);
	}

	/**
	 * @param arr
	 * @param i
	 * @param j
	 * @return
	 */
	private static int minCostTabular(int[][] arr, int ei, int ej) {
		int[][] dp = new int[ej][ej];
		dp[ei - 1][ej - 1] = arr[ei - 1][ej - 1];
		for (int i = ei - 2; i >= 0; i--) {
			dp[i][ej - 1] = arr[i][ej - 1] + dp[i + 1][ej - 1];
		}
		for (int j = ej - 2; j >= 0; j--) {
			dp[ei - 1][j] = dp[ei - 1][j + 1] + arr[ei - 1][j];
		}
		for (int i = ei - 2; i >= 0; i--) {
			for (int j = ej - 2; j >= 0; j--) {
				// System.out.println();
				dp[i][j] = arr[i][j] + Math.min(dp[i + 1][j], Math.min(dp[i + 1][j + 1], dp[i][j + 1]));
				// System.out.println(dp[i][j] + " ");
			}
		}
		return dp[0][0];
	}

	/**
	 * @param arr
	 * @param i
	 * @param j
	 * @param k
	 * @param l
	 * @return
	 */
	private static int minCostMemo(int[][] arr, int ei, int ej, int si, int sj) {
		if (si == ei && sj == ej) {
			return arr[si][sj];
		}
		if (si > ei || sj > ej) {
			return Integer.MAX_VALUE;
		}
		if (memo[si][sj] != Integer.MAX_VALUE) {
			return memo[si][sj];
		}
		int opt1 = minCostRec(arr, ei, ej, si + 1, sj);
		int opt2 = minCostRec(arr, ei, ej, si, sj + 1);
		int opt3 = minCostRec(arr, ei, ej, si + 1, sj + 1);
		memo[si][sj] = arr[si][sj] + Math.min(opt1, Math.min(opt2, opt3));
		return arr[si][sj] + Math.min(opt1, Math.min(opt2, opt3));
	}

	/**
	 * @param arr
	 * @param i
	 * @param j
	 * @param k
	 * @param l
	 * @return
	 */
	private static int minCostRec(int[][] arr, int ei, int ej, int si, int sj) {
		if (si == ei && sj == ej) {
			return arr[ei][ej];
		}
		if (si > ei || sj > ej) {
			return Integer.MAX_VALUE;
		}

		int opt1 = minCostRec(arr, ei, ej, si + 1, sj);
		int opt2 = minCostRec(arr, ei, ej, si + 1, sj + 1);
		int opt3 = minCostRec(arr, ei, ej, si, sj + 1);
		return arr[si][sj] + Math.min(opt1, Math.min(opt2, opt3));
	}

}
